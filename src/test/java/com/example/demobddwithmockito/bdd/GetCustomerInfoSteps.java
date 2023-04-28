package com.example.demobddwithmockito.bdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demobddwithmockito.controller.DemoController;
import com.example.demobddwithmockito.dto.CustomerInfoResponse;
import com.example.demobddwithmockito.model.CustomerEntity;
import com.example.demobddwithmockito.model.CustomerService;
import com.example.demobddwithmockito.service.ServiceA;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GetCustomerInfoSteps {

  CustomerInfoResponse customerInfoResponse;
  @Mock
  ServiceA serviceA;

  @Mock
  CustomerService customerService;

  @InjectMocks
  DemoController demoController;

  @Captor
  ArgumentCaptor<CustomerEntity> customerEntityArgumentCaptor;

  @Before
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    customerInfoResponse = CustomerInfoResponse.builder()
        .name("CustomerName")
        .phoneNumber("09888888338")
        .build();
  }

  @Given("I get customer information from Service A")
  public void iGetCustomerInformationFromServiceA() {

  }

  @When("the response is received with status is TRUE")
  public void theResponseStatusIsTRUE() {
    customerInfoResponse.setStatus(Boolean.TRUE);
    when(serviceA.getCustomerInfo("customer1")).thenReturn(customerInfoResponse);
  }

  @Then("the customer information is saved in the database")
  public void theCustomerInformationIsSavedInTheDatabase() {
    demoController.getCustomerInfo("customer1");
    verify(customerService).save(customerEntityArgumentCaptor.capture());

    assertEquals(customerInfoResponse.getName(), customerEntityArgumentCaptor.getValue().getName());
    assertEquals(customerInfoResponse.getPhoneNumber(), customerEntityArgumentCaptor.getValue().getPhoneNumber());
  }
}
