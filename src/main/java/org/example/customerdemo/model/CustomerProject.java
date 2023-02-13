package org.example.customerdemo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projects", schema = "project")
public class CustomerProject extends BaseEntity {

    @Column(name = "name_project")
    private String nameProject;

    @ToString.Exclude
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinColumn(name = "id_project")
    private Set<CustomerAttribute> customerAttributes;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinColumn(name = "id_project")
    private Set<CustomerGeometry> customerGeometries;
}
