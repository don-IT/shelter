Feature: Animal Management

  Scenario: Create a new animal
    Given the animal data:
      | name    | Bella       |
      | species | Dog         |
      | age     | 3           |
      | status  | AVAILABLE   |
    When I send POST request to "/api/animals"
    Then the response status should be 200
    And the response should contain field "name" = "Bella"

  Scenario: Get all animals
    When I send GET request to "/api/animals"
    Then the response status should be 200
    And the response should contain at least one animal with name "Bella"

  Scenario: Update animal status
    Given the animal exists with name "Bella"
    When I send PUT request to "/api/animals/{id}/status" with status "ADOPTED"
    Then the response status should be 200
    And the response should contain field "status" = "ADOPTED"
