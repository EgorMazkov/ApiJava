package org.example.customerdemo.dto;

import lombok.Data;
import org.example.customerdemo.model.CustomerAttribute;
import org.example.customerdemo.model.CustomerGeometry;

import java.util.Set;

@Data
public class ProjectDto {
    String name;
    Set<CustomerAttribute> customerAttributes;
    Set<CustomerGeometry> customerGeometries;
}
