package org.example.customerdemo.dto;

import lombok.Data;
import org.example.customerdemo.model.CustomerAttribute;
import org.example.customerdemo.model.CustomerGeometry;

import java.util.Set;

@Data// todo зачем Data, если поля не final?
public class ProjectDto {
    String name;// todo почему package-private?
    Set<CustomerAttribute> customerAttributes;
    Set<CustomerGeometry> customerGeometries;
}
