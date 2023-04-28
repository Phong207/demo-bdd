package com.example.demobddwithmockito.bdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.demobddwithmockito.controller.DemoController;
import com.example.demobddwithmockito.dto.CustomerInfoResponse;
import com.example.demobddwithmockito.service.ServiceA;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PhoneNumberCheckSteps {

  private List<String> areaCodeList;

  @Mock
  ServiceA serviceA;

  @InjectMocks
  DemoController demoController;

  @Before
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }


  @Given("a list of Viettel area codes:")
  public void aListOfViettelAreaCodes(List<String> areaCodes) {
    areaCodeList = areaCodes;
  }

  @When("The response phone number is {string} with the first 3 numbers in the area code of Viettel")
  public void theResponsePhoneNumberIsWithTheFirstNumbersInTheAreaCodeOfViettel(String phoneNumber) {
    when(serviceA.getCustomerInfo("customer1")).thenReturn(
        CustomerInfoResponse.builder().phoneNumber(phoneNumber).build()
    );
  }

  @Then("the demo process identifies the customer's network as Viettel")
  public void theDemoProcessIdentifiesTheCustomerSNetworkAsViettel() {
    String expect = demoController.checkPhoneNumber("customer1", areaCodeList);

    assertEquals("VIETTEL", expect);
  }
}
