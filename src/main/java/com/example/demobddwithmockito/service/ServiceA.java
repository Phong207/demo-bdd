package com.example.demobddwithmockito.service;

import com.example.demobddwithmockito.dto.CustomerInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServiceA {

  public CustomerInfoResponse getCustomerInfo(String customerCode) {
    return null;
  }
}
