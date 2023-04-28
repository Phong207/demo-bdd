package com.example.demobddwithmockito.controller;

import static java.lang.Boolean.TRUE;

import com.example.demobddwithmockito.dto.CustomerInfoResponse;
import com.example.demobddwithmockito.model.CustomerEntity;
import com.example.demobddwithmockito.model.CustomerService;
import com.example.demobddwithmockito.service.ServiceA;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class DemoController {

  private final ServiceA serviceA;

  private final CustomerService customerService;

  public void getCustomerInfo(String customerCode) {

    try {

      CustomerInfoResponse customerInfo = serviceA.getCustomerInfo(customerCode);

      if (TRUE.equals(customerInfo.getStatus())) {
        customerService.save(CustomerEntity.builder().name(customerInfo.getName())
            .phoneNumber(customerInfo.getPhoneNumber()).build());
      }

    } catch (Exception e) {
      log.error("error");
    }
  }

  public String checkPhoneNumber(String customerCode, List<String> areaCodes) {

    CustomerInfoResponse customerInfo = serviceA.getCustomerInfo(customerCode);

    if (areaCodes.contains(customerInfo.getPhoneNumber().substring(0, 3))) {
      return "VIETTEL";
    }
    return "";
  }
}
