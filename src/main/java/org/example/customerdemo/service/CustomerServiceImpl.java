package org.example.customerdemo.service;

import lombok.RequiredArgsConstructor;
import org.example.customerdemo.model.CustomerGeometry;
import org.example.customerdemo.model.CustomerProject;
import org.example.customerdemo.repository.CustomerRepository;
import org.example.customerdemo.repository.CustomerRepositoryGeometry;
import org.example.customerdemo.utils.CreateCustomerProjectAndAttributeAndGeometry;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Set;

// todo не используется delete @Slf4j DONE
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerRepositoryGeometry customerRepositoryGeometry;

    private final CreateCustomerProjectAndAttributeAndGeometry createCustomerProjectAndAttributeAndGeometry;


    @Override
    public CustomerProject findById(Long id){
        CustomerProject customerProject = customerRepository.findByIdCustomerAttribute(id);
        Set<CustomerGeometry> geometries = customerRepositoryGeometry.findByIdCustomerGeometries(id);
        customerProject.setCustomerGeometries(geometries);
        return customerProject;
    }


    @Override
    @Transactional
    // todo @Transactional DONE
    public void createProjectByDB(String name, String nameMethod, CustomerProject customerProject) { // createProjectDB
        if (nameMethod.equals("save"))
            customerProject = createCustomerProjectAndAttributeAndGeometry.createProject(name);
        customerRepository.save(customerProject);
    }

    @Override
    @Transactional
    // todo @Transactional DONE
    public void deletingAProjectFromTheDB(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerProject> getAllProject() {
        return customerRepository.findAll();
    }

    @Override
    public void findByIdAndUpdateNameCustomerProject(Long id) {
        CustomerProject customerProject = customerRepository.findByIdCustomerAttribute(id);
        Set<CustomerGeometry> geometries = customerRepositoryGeometry.findByIdCustomerGeometries(id);
        customerProject.setCustomerGeometries(geometries);

        try {
            customerProject = createCustomerProjectAndAttributeAndGeometry.renameNameProject(customerProject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        createProjectByDB("", "findById", customerProject);
    }
}
