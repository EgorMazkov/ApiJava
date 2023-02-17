package org.example.customerdemo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Attribute", schema = "project")
@Getter
@Setter
@ToString// todo при вызове этого метода будут дергаться Lazy сущности. Проблема n + 1
@NoArgsConstructor
public class CustomerAttribute extends BaseEntity {

    @Column(name = "name_Attribute")
    private String name;

    @JsonBackReference// todo не нужно
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project")
    private CustomerProject customerProject;
}
