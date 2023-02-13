package org.example.customerdemo.utils;

import org.example.customerdemo.model.CustomerAttribute;
import org.example.customerdemo.model.CustomerGeometry;
import org.example.customerdemo.model.CustomerProject;
import org.example.customerdemo.dto.ProjectDto;
import org.example.customerdemo.dto.AttrAndGeomDto;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CreateCustomer {
    MappingAll mappingAttr = new MappingAll();


    public CustomerProject createProject(String name) {
        CustomerProject project = new CustomerProject();

        Set<CustomerAttribute> attributes = createSetAttr();
        Set<CustomerGeometry> geometries = createSetGeom();

        ProjectDto dto = mappingAttr.mapToProjectDto(name, attributes, geometries);
        project = mappingAttr.mapToProject(dto);

        return project;
    }

    private Set<CustomerGeometry> createSetGeom() {
        Set<CustomerGeometry> geometries = new HashSet<>();
        for (long i = 0; i < 100000; i++) {
//        for (long i = 0; i < 10; i++) {
            AttrAndGeomDto dto =  mappingAttr.mapToGeomDto(i);
            geometries.add(mappingAttr.mapToGeom(dto));
        }
        return geometries;
    }

    private Set<CustomerAttribute> createSetAttr() {
        Set<CustomerAttribute> attributes = new HashSet<>();
        for (long i = 0; i < 100000; i++) {
//        for (long i = 0; i < 10; i++) {
            AttrAndGeomDto dto =  mappingAttr.mapToAttrDto(i);
            attributes.add(mappingAttr.mapToAttr(dto));
        }

        return attributes;
    }

    public CustomerProject renameNameProject(CustomerProject customerProject) throws IOException {
        FileReader reader = new FileReader("src/main/resources/params.txt");
        Scanner scanner = new Scanner(reader);
        String name = scanner.next();

        reader.close();
        scanner.close();

        customerProject = mappingAttr.renameNameProject(customerProject, name);


        return customerProject;
    }
}
