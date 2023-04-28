package com.example.demobddwithmockito.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl {

  private final CustomerRepository customerRepository;

}
