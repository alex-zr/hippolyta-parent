package ua.kiev.prog.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="CONTACT-VALIDATOR-SERVICE") // Имя используемое для балансировщика ribbon
public interface ValidationClient {
    @GetMapping(value = "/contact/validate")
    String validate(@RequestParam("phoneNumber") String phoneNumber);
}
