package org.example.customerdemo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@MappedSuperclass
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// todo делай почаще реформат кода Ctrl + Alt + L DONE
    protected Long id;
}
