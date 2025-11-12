package com.shelter.shelter.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InitialServiceTest {
  @InjectMocks InitialService initialService;

  @Test
  void sayHi() {
    Assertions.assertEquals("Hello World", initialService.sayHi());
  }
}
