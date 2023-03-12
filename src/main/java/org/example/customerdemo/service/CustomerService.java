package org.example.customerdemo.service;

import org.example.customerdemo.model.CustomerProject;

import java.util.List;

public interface CustomerService {

    CustomerProject findById(Long id);

        // todo camelCase не соблюдается  delete method DONE

    void createProjectByDB(String name, String nameMethod, CustomerProject customerProject);

    void deletingAProjectFromTheDB(Long id);

    List<CustomerProject> getAllProject();

    void findByIdAndUpdateNameCustomerProject(Long id);
}
