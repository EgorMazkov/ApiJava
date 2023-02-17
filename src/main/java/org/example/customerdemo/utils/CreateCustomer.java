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

public class CreateCustomer {// todo название не очень
    MappingAll mappingAttr = new MappingAll();// todo @Service через new плохая практика + модификаторы доступа


    public CustomerProject createProject(String name) {
        CustomerProject project = new CustomerProject();// todo зачем объявлять переменную наверху, если ты ее перезаписываешь и до перезаписи не используешь?
//todo к чему этот пропуск строки?
        Set<CustomerAttribute> attributes = createSetAttr();// todo название
        Set<CustomerGeometry> geometries = createSetGeom();// todo название

        ProjectDto dto = mappingAttr.mapToProjectDto(name, attributes, geometries);
        project = mappingAttr.mapToProject(dto);
//todo к чему этот пропуск строки?
        return project;
    }

    private Set<CustomerGeometry> createSetGeom() {
        Set<CustomerGeometry> geometries = new HashSet<>();
        for (long i = 0; i < 100000; i++) {// todo используй стримы + убери магические числа выносом в константу
//        for (long i = 0; i < 10; i++) {// todo коммент в коде
            AttrAndGeomDto dto =  mappingAttr.mapToGeomDto(i);
            geometries.add(mappingAttr.mapToGeom(dto));
        }
        return geometries;
    }

    private Set<CustomerAttribute> createSetAttr() {
        Set<CustomerAttribute> attributes = new HashSet<>();
        for (long i = 0; i < 100000; i++) {// todo используй стримы + убери магические числа выносом в константу
//        for (long i = 0; i < 10; i++) {// todo коммент в коде
            AttrAndGeomDto dto =  mappingAttr.mapToAttrDto(i);
            attributes.add(mappingAttr.mapToAttr(dto));
        }
//todo к чему этот пропуск строки?
        return attributes;
    }

    public CustomerProject renameNameProject(CustomerProject customerProject) throws IOException {
        FileReader reader = new FileReader("src/main/resources/params.txt");// todo вынести в константу
        Scanner scanner = new Scanner(reader);
        String name = scanner.next();
//todo к чему этот пропуск строки?
        reader.close();// todo используй try-with-resources
        scanner.close();// todo используй try-with-resources
//todo к чему этот пропуск строки?
        customerProject = mappingAttr.renameNameProject(customerProject, name);
//todo к чему этот пропуск строки?
//todo к чему этот пропуск строки?
        return customerProject;
    }
}
