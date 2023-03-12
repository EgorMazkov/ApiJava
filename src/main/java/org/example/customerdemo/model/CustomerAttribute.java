package org.example.customerdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Attribute", schema = "project")
@Getter
@Setter
// todo при вызове этого метода будут дергаться Lazy сущности. Проблема n + 1 = без него тоже работает DONE
@NoArgsConstructor
public class CustomerAttribute extends BaseEntity {

    @Column(name = "name_Attribute")
    private String name;

    // todo не нужно  delete JsonBackReference DONE
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project")
    private CustomerProject customerProject;
}
