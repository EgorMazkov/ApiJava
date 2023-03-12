package org.example.customerdemo.dto;

import lombok.Data;
import org.example.customerdemo.model.CustomerProject;

@Data// todo зачем Data, если поля не final?
public class AttributeAndGeometryDto {// todo название полностью DONE
    String name;// todo почему package-private?
    CustomerProject customerProject;
}
