package org.example.customerdemo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.customerdemo.model.CustomerProject;
import org.example.customerdemo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j// todo не используется
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerProject getbyId(Long id) {
        return customerRepository.findAbobaById(id);
    }

    @Override
    // todo @Transactional
    public void save(CustomerProject customerProject) {
        customerRepository.save(customerProject);
    }

    @Override
    // todo @Transactional
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerProject> getAll() {
        return customerRepository.findAll();
    }
}
