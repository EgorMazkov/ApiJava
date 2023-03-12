package org.example.customerdemo.rest;

import lombok.RequiredArgsConstructor;
import org.example.customerdemo.model.CustomerProject;
import org.example.customerdemo.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")// todo "/" в конце лучше удалить и распихать в начало всех методов, так красивее DONE
public class ProjectController {// todo название ProjectController DONE

    //todo инжект на поле плохая практика, сделай final или поставь @Autowired над конструктором DONE
    private final CustomerService customerService;



    // todo тут как хочешь, но @GetMapping лаконичнее    delete RequestMapping DONE
    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerProject> getCustomer(@PathVariable("id") Long id) {
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CustomerProject> saveCustomer(@RequestParam(required = false) String name) { //todo к чему этот пропуск строки? DONE
       //todo к чему этот пропуск строки? DONE
        //TODO "api\project?name=123" DONE
        customerService.createProjectByDB(name, "save", new CustomerProject()); //todo к чему этот пропуск строки? DONE //todo к чему этот пропуск строки? DONE
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "")
    public ResponseEntity<CustomerProject> updateCustomer(@RequestParam(required = false) Long id) {
        customerService.findByIdAndUpdateNameCustomerProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "")
    public ResponseEntity<CustomerProject> deleteCustomer(@RequestParam(required = false) Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.deletingAProjectFromTheDB(id); //todo к чему этот пропуск строки? DONE
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<List<CustomerProject>> getAll() {
        List<CustomerProject> customerProjects = customerService.getAllProject();// todo this не нужен DONE //todo к чему этот пропуск строки? DONE
        if (customerProjects == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } //todo к чему этот пропуск строки? DONE
        return new ResponseEntity<>(customerProjects, HttpStatus.OK);
    }
}
