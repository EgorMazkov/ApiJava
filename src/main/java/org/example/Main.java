package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO при выполение post так как 100000 надо создать, выводиться timeout
@SpringBootApplication
public class Main {

    public static int id = 1;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

}