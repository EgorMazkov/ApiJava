package org.example.customerdemo.model;

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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)// todo использование каскадных правил плохая практика = временный DONE
    // todo не нужно DONE delete JsonBackReference
    @JoinColumn(name = "id_project")
    private Set<CustomerAttribute> customerAttributes;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)// todo использование каскадных правил плохая практика = временный DONE
    // todo не нужно DONE delete JsonBackReference
    @JoinColumn(name = "id_project")
    private Set<CustomerGeometry> customerGeometries;

}
