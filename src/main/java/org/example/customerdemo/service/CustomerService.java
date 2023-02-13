package org.example.customerdemo.service;

import org.example.customerdemo.model.CustomerProject;

import java.util.List;

public interface CustomerService {
    CustomerProject getbyId(Long id);

    void save(CustomerProject customerProject);

    void delete(Long id);

    List<CustomerProject> getAll();
}