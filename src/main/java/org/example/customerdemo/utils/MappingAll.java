package org.example.customerdemo.utils;

import org.example.customerdemo.dto.AttrAndGeomDto;
import org.example.customerdemo.dto.ProjectDto;
import org.example.customerdemo.model.CustomerAttribute;
import org.example.customerdemo.model.CustomerGeometry;
import org.example.customerdemo.model.CustomerProject;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MappingAll {

    public CustomerAttribute mapToAttr (AttrAndGeomDto dto) {
        CustomerAttribute attribute = new CustomerAttribute();
        attribute.setName(dto.getName());
//todo к чему этот пропуск строки?
        return attribute;
    }

    public CustomerGeometry mapToGeom (AttrAndGeomDto dto) {
        CustomerGeometry geometry = new CustomerGeometry();
        geometry.setName(dto.getName());
//todo к чему этот пропуск строки?
        return geometry;
    }

    public AttrAndGeomDto mapToAttrDto(Long i) {// todo название аргумента не несет никакой информации
        AttrAndGeomDto dto = new AttrAndGeomDto();
        dto.setName("Attr" + i);// todo магические буквы
//todo к чему этот пропуск строки?
        return dto;
    }

    public AttrAndGeomDto mapToGeomDto(Long i) {// todo название аргумента не несет никакой информации
        AttrAndGeomDto dto = new AttrAndGeomDto();
        dto.setName("Geom" + i);// todo магические буквы
//todo к чему этот пропуск строки?
        return dto;
    }

    public ProjectDto mapToProjectDto(String name, Set<CustomerAttribute> customerAttributes, Set<CustomerGeometry> customerGeometries) {
        ProjectDto dto = new ProjectDto();
//todo к чему этот пропуск строки?
        dto.setName(name);
        dto.setCustomerAttributes(customerAttributes);
        dto.setCustomerGeometries(customerGeometries);
//todo к чему этот пропуск строки?
        return dto;
    }

    public CustomerProject mapToProject(ProjectDto dto) {
        CustomerProject project = new CustomerProject();
//todo к чему этот пропуск строки?
        project.setNameProject(dto.getName());
        project.setCustomerAttributes(dto.getCustomerAttributes());
        project.setCustomerGeometries(dto.getCustomerGeometries());
//todo к чему этот пропуск строки?
        return project;
    }

    public CustomerProject renameNameProject(CustomerProject customerProject, String name) {
        customerProject.setNameProject(name);
//todo к чему этот пропуск строки?
        return customerProject;
    }

}
