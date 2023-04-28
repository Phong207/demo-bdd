package com.example.demobddwithmockito;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
    glue = "com.example.demobddwithmockito.bdd",
    features = "classpath:features/check_phone_number.feature")
public class PhoneNumberCheckTest {

}
