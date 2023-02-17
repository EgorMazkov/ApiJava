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
@RequestMapping("/api/projects/")// todo "/" в конце лучше удалить и распихать в начало всех методов, так красивее
public class RestCustomerContorllerV1 {// todo название ProjectController

    @Autowired//todo инжект на поле плохая практика, сделай final или поставь @Autowired над конструктором
    public CustomerService customerService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)// todo тут как хочешь, но @GetMapping лаконичнее
    public ResponseEntity<CustomerProject> getCustomer(@PathVariable("id") Long id) {
        System.out.println("POST request GET {id} - " + id);// todo логирование через System.out.println не очень, используй @Slf4j и его logger (log.info())
        if (id == null) {// todo в этот if никогда не провалится
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CustomerProject customerProject = customerService.getbyId(id);
//todo к чему этот пропуск строки?
        if (customerProject == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// todo лучше сделать через бросание exception при отсутствии customerProject на уровне CustomerService и ловить такие исключения в @AdviceController или просто использовать Optional
        }
//todo к чему этот пропуск строки?
        return new ResponseEntity<>(customerProject, HttpStatus.OK);
    }

    @RequestMapping(value = "{name}", method = RequestMethod.POST)
    public ResponseEntity<CustomerProject> saveCustomer(@PathVariable("name") String name) {
//todo к чему этот пропуск строки?
        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
//todo к чему этот пропуск строки?
        CreateCustomer createCustomer = new CreateCustomer();
        CustomerProject project = createCustomer.createProject(name);
        customerService.save(project);
//todo к чему этот пропуск строки?
//todo к чему этот пропуск строки?
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<CustomerProject> updateCustomer(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
//todo к чему этот пропуск строки?
        CustomerProject customerProject = customerService.getbyId(id);
        CreateCustomer createCustomer = new CreateCustomer();
        try {
            customerProject = createCustomer.renameNameProject(customerProject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//todo к чему этот пропуск строки?
        if (customerProject == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
//todo к чему этот пропуск строки?
        this.customerService.save(customerProject);
//todo к чему этот пропуск строки?
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CustomerProject> deleteCustomer(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.delete(id);
//todo к чему этот пропуск строки?
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<CustomerProject>> getAll() {
        List<CustomerProject> customerProjects = this.customerService.getAll();// todo this не нужен
//todo к чему этот пропуск строки?
        if (customerProjects == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//todo к чему этот пропуск строки?
        return new ResponseEntity<>(customerProjects, HttpStatus.OK);
    }
}
