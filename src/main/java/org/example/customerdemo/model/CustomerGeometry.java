package org.example.customerdemo.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Geometry", schema = "project")
@Getter
@Setter
@ToString// todo n + 1
@NoArgsConstructor
public class CustomerGeometry extends BaseEntity{

    @Column(name = "name_Geomerty")
    private String name;

    @JsonBackReference// todo не нужно
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project")
    private CustomerProject customerProject;
}
