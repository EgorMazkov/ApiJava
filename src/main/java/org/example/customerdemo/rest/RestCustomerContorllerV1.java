package org.example.customerdemo.rest;

import org.example.customerdemo.model.CustomerProject;
import org.example.customerdemo.service.CustomerService;
import org.example.customerdemo.utils.CreateCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/projects/")
public class RestCustomerContorllerV1 {

    @Autowired
    public CustomerService customerService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerProject> getCustomer(@PathVariable("id") Long id) {
        System.out.println("POST request GET {id} - " + id);
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CustomerProject customerProject = customerService.getbyId(id);

        if (customerProject == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerProject, HttpStatus.OK);
    }

    @RequestMapping(value = "{name}", method = RequestMethod.POST)
    public ResponseEntity<CustomerProject> saveCustomer(@PathVariable("name") String name) {

        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        CreateCustomer createCustomer = new CreateCustomer();
        CustomerProject project = createCustomer.createProject(name);
        customerService.save(project);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<CustomerProject> updateCustomer(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        CustomerProject customerProject = customerService.getbyId(id);
        CreateCustomer createCustomer = new CreateCustomer();
        try {
            customerProject = createCustomer.renameNameProject(customerProject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (customerProject == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.customerService.save(customerProject);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CustomerProject> deleteCustomer(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<CustomerProject>> getAll() {
        List<CustomerProject> customerProjects = this.customerService.getAll();

        if (customerProjects == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerProjects, HttpStatus.OK);
    }
}
