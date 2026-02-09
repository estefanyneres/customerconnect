package tech.buildrun.customerconnect.service;

import org.springframework.stereotype.Service;
import tech.buildrun.customerconnect.controller.dto.CreateCustomerDto;
import tech.buildrun.customerconnect.entity.CustomerEntity;
import tech.buildrun.customerconnect.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public CustomerEntity createCustomer(CreateCustomerDto dto) {
        var entity = new CustomerEntity();
        entity.setFullName(dto.fullName());
        entity.setCpf(dto.cpf());
        entity.setEmail(dto.email());
        entity.setPhoneNumber(dto.phoneNumber());

        return customerRepository.save(entity);
    }
}
