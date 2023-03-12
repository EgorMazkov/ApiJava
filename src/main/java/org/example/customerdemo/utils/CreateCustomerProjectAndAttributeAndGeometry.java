package org.example.customerdemo.utils;

import org.example.customerdemo.model.CustomerAttribute;
import org.example.customerdemo.model.CustomerGeometry;
import org.example.customerdemo.model.CustomerProject;
import org.example.customerdemo.dto.ProjectDto;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


@Service
//@RequiredArgsConstructor
public class CreateCustomerProjectAndAttributeAndGeometry {// todo название не очень Done

    final int MAX_NUMBER_ATTRIBUTE_AND_GEOMETRY = 100000; // TODO update 100000
    static final String PATH_FILE = "src/main/resources/params.txt";


    private final MappingAll mappingAll;

    public CreateCustomerProjectAndAttributeAndGeometry(MappingAll mappingAll) {
        this.mappingAll = mappingAll;
    }


//    MappingAll mappingAll = new MappingAll(); // todo @Service через new плохая практика + модификаторы доступа

    public CustomerProject createProject(String name) {
        // todo зачем объявлять переменную наверху, если ты ее перезаписываешь и до перезаписи не используешь? DONE //todo к чему этот пропуск строки? DONE
        Set<CustomerAttribute> setCustomerAttribute = createSetCustomerAttribute();// todo название DONE
        Set<CustomerGeometry> setCustomerGeometry = createSetCustomerGeometry();// todo название DONE

        ProjectDto dto = mappingAll.mapToProjectDto(name, setCustomerAttribute, setCustomerGeometry);
        return mappingAll.mapToProject(dto);
    }


    private Set<CustomerGeometry> createSetCustomerGeometry() {
        return LongStream.range(0, MAX_NUMBER_ATTRIBUTE_AND_GEOMETRY)
                .mapToObj(mappingAll::mapToGeomDto)
                .map(mappingAll::mapToGeom)
                .collect(Collectors.toSet());
    }

    private Set<CustomerAttribute> createSetCustomerAttribute() {
        return LongStream.range(0, MAX_NUMBER_ATTRIBUTE_AND_GEOMETRY)
                .mapToObj(mappingAll::mapToAttrDto)
                .map(mappingAll::mapToAttr)
                .collect(Collectors.toSet());
    }

    public CustomerProject renameNameProject(CustomerProject customerProject) throws IOException {
        String name = readFile(); //todo к чему этот пропуск строки? DONE //todo к чему этот пропуск строки? DONE
        customerProject = mappingAll.renameNameProject(customerProject, name); //todo к чему этот пропуск строки?  delete DONE // todo к чему этот пропуск строки?   delete DONE
        return customerProject;
    }

    private static String readFile() throws IOException {
        try (FileReader reader = new FileReader(PATH_FILE); // todo вынести в константу DONE
             Scanner scanner = new Scanner(reader)) {
            return scanner.next();
        }
    }
}
