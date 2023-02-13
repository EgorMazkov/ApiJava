package org.example.customerdemo.dto;

import lombok.Data;
import org.example.customerdemo.model.CustomerProject;

@Data
public class AttrAndGeomDto {
    String name;
    CustomerProject customerProject;
}
