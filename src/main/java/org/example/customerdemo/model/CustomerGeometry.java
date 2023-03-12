package org.example.customerdemo.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Geometry", schema = "project")
@Getter
@Setter
// todo n + 1 DONE
@NoArgsConstructor
public class CustomerGeometry extends BaseEntity{

    @Column(name = "name_Geomerty")
    private String name;

    // todo не нужно DONE delete JsonBackReference
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project")
    private CustomerProject customerProject;
}
