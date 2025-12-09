package com.shelter.shelter.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.shelter.shelter.dtos.AnimalDTO;
import io.cucumber.java.en.*;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.test.web.reactive.server.WebTestClient;

@Slf4j
public class AnimalStepDefs {

  private final WebTestClient webTestClient;
  private Map<String, Object> requestBody;
  private WebTestClient.ResponseSpec response;

  public AnimalStepDefs(WebTestClient webTestClient) {
    this.webTestClient = webTestClient;
  }

  @Given("the animal data:")
  public void the_animal_data(Map<String, Object> data) {
    this.requestBody = new HashMap<>();
    // Ensure all keys match DTO/Entity exactly
    this.requestBody.put("name", data.get("name"));
    this.requestBody.put("species", data.get("species"));
    this.requestBody.put("age", Integer.parseInt(data.get("age").toString()));
    this.requestBody.put("status", data.get("status"));
  }

  @When("I send POST request to {string}")
  public void i_send_post_request_to(String endpoint) {
    response = webTestClient.post().uri(endpoint).bodyValue(requestBody).exchange();
  }

  @When("I send GET request to {string}")
  public void i_send_get_request_to(String endpoint) {
    response = webTestClient.get().uri(endpoint).exchange();
  }

  @When("I send PUT request to {string} with status {string}")
  public void i_send_put_request_to_with_status(String endpoint, String status) {
    var body = response.expectBody(AnimalDTO.class).returnResult().getResponseBody();

    assertThat(body).isNotNull();
    var url = endpoint.replace("{id}", body.getId().toString());
    response =
        webTestClient
            .put()
            .uri(uriBuilder -> uriBuilder.path(url).queryParam("status", status).build())
            .exchange();
  }

  @Given("the animal exists with name {string}")
  public void the_animal_exists_with_name(String name) {
    requestBody = Map.of("name", name, "species", "Dog", "age", 3, "status", "AVAILABLE");

    i_send_post_request_to("/api/animals");
  }

  @Then("the response status should be {int}")
  public void the_response_status_should_be(int status) {
    response.expectStatus().isEqualTo(status);
  }

  @Then("the response should contain field {string} = {string}")
  public void the_response_should_contain_field(String field, String value) {
    var body = response.expectBody(AnimalDTO.class).returnResult().getResponseBody();

    assertThat(body).isNotNull();

    if (field.equals("name")) {
      assertThat(body.getName()).isEqualTo(value);
    } else if (field.equals("status")) {
      assertThat(body.getStatus()).hasToString(value);
    } else {
      throw new IllegalArgumentException("Unknown field: " + field);
    }
  }

  @Then("the response should contain at least one animal with name {string}")
  public void the_response_should_contain_at_least_one_animal_with(String value) {
    var animals = response.expectBodyList(AnimalDTO.class).returnResult().getResponseBody();

    assertThat(animals)
        .isNotNull()
        .anySatisfy(animal -> assertThat(animal.getName()).isEqualTo(value));
  }
}
