package org.example.customerdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.customerdemo.model.CustomerAttribute;
import org.example.customerdemo.model.CustomerGeometry;

import java.util.Set;

@AllArgsConstructor
@Data
public class ProjectDto {
    private String name;// todo почему package-private? DONE
    private Set<CustomerAttribute> customerAttributes;
    private Set<CustomerGeometry> customerGeometries;
}
