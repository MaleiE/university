package com.malei.spring.boot.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@ToString
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "specialization")
public class Specialization extends AbstractNameAndDescriptionObject  {
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialization")
    private Set<Groups> groups = new HashSet<>();

}
