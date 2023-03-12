package org.example.customerdemo.utils;

import org.example.customerdemo.dto.AttributeAndGeometryDto;
import org.example.customerdemo.dto.ProjectDto;
import org.example.customerdemo.model.CustomerAttribute;
import org.example.customerdemo.model.CustomerGeometry;
import org.example.customerdemo.model.CustomerProject;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MappingAll {

    private final String NAME_ATTRIBUTE = "Attr ";
    private final String NAME_GEOMERTY = "Geom ";

    public CustomerAttribute mapToAttr (AttributeAndGeometryDto dto) {
        CustomerAttribute attribute = new CustomerAttribute();
        attribute.setName(dto.getName()); //todo к чему этот пропуск строки? DONE delele
        return attribute;
    }

    public CustomerGeometry mapToGeom (AttributeAndGeometryDto dto) {
        CustomerGeometry geometry = new CustomerGeometry();
        geometry.setName(dto.getName()); //todo к чему этот пропуск строки? DONE delele
        return geometry;
    }

    public AttributeAndGeometryDto mapToAttrDto(Long numberAttribute) {// todo название аргумента не несет никакой информации DONE
        AttributeAndGeometryDto dto = new AttributeAndGeometryDto();
        dto.setName(NAME_ATTRIBUTE + numberAttribute);// todo магические буквы DONE //todo к чему этот пропуск строки? DONE delele
        return dto;
    }

    public AttributeAndGeometryDto mapToGeomDto(Long numberGeometry) {// todo название аргумента не несет никакой информации DONE
        AttributeAndGeometryDto dto = new AttributeAndGeometryDto();
        dto.setName(NAME_GEOMERTY + numberGeometry);// todo магические буквы DONE //todo к чему этот пропуск строки? DONE delele
        return dto;
    }

    public ProjectDto mapToProjectDto(String name, Set<CustomerAttribute> customerAttributes, Set<CustomerGeometry> customerGeometries) {
        ProjectDto dto = new ProjectDto(name,
                customerAttributes,
                customerGeometries
        ); //todo к чему этот пропуск строки? DONE delele
//        dto.setName(name);
//        dto.setCustomerAttributes(customerAttributes);
//        dto.setCustomerGeometries(customerGeometries); //todo к чему этот пропуск строки? DONE delele
        return dto;
    }

    public CustomerProject mapToProject(ProjectDto dto) {
        CustomerProject project = new CustomerProject(); //todo к чему этот пропуск строки? DONE delele
        project.setNameProject(dto.getName());
        project.setCustomerAttributes(dto.getCustomerAttributes());
        project.setCustomerGeometries(dto.getCustomerGeometries()); //todo к чему этот пропуск строки? DONE delele
        return project;
    }

    public CustomerProject renameNameProject(CustomerProject customerProject, String name) {
        customerProject.setNameProject(name); //todo к чему этот пропуск строки? DONE delele
        return customerProject;
    }
}
