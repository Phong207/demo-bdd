package com.example.demobddwithmockito.service;

import com.example.demobddwithmockito.dto.CustomerInfoResponse;

public interface ServiceA {

  CustomerInfoResponse getCustomerInfo(String customerCode);
}
