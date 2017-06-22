package com.malei.spring.boot.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "faculty")
public class Faculty extends AbstractNameAndDescriptionObject {
    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "faculty")
    private Set<Specialization> specializations = new HashSet<>();

}
