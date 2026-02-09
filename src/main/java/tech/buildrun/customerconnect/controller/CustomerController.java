package tech.buildrun.customerconnect.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.buildrun.customerconnect.controller.dto.CreateCustomerDto;
import tech.buildrun.customerconnect.service.CustomerService;

import java.net.URI;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CreateCustomerDto dto){
        var customer = customerService.createCustomer(dto);

        return ResponseEntity.created(
                URI.create("/customers/" + customer.getCustomerId())
        ).build();
    }
}
