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

        return attribute;
    }

    public CustomerGeometry mapToGeom (AttrAndGeomDto dto) {
        CustomerGeometry geometry = new CustomerGeometry();
        geometry.setName(dto.getName());

        return geometry;
    }

    public AttrAndGeomDto mapToAttrDto(Long i) {
        AttrAndGeomDto dto = new AttrAndGeomDto();
        dto.setName("Attr" + i);

        return dto;
    }

    public AttrAndGeomDto mapToGeomDto(Long i) {
        AttrAndGeomDto dto = new AttrAndGeomDto();
        dto.setName("Geom" + i);

        return dto;
    }

    public ProjectDto mapToProjectDto(String name, Set<CustomerAttribute> customerAttributes, Set<CustomerGeometry> customerGeometries) {
        ProjectDto dto = new ProjectDto();

        dto.setName(name);
        dto.setCustomerAttributes(customerAttributes);
        dto.setCustomerGeometries(customerGeometries);

        return dto;
    }

    public CustomerProject mapToProject(ProjectDto dto) {
        CustomerProject project = new CustomerProject();

        project.setNameProject(dto.getName());
        project.setCustomerAttributes(dto.getCustomerAttributes());
        project.setCustomerGeometries(dto.getCustomerGeometries());

        return project;
    }

    public CustomerProject renameNameProject(CustomerProject customerProject, String name) {
        customerProject.setNameProject(name);

        return customerProject;
    }

}
