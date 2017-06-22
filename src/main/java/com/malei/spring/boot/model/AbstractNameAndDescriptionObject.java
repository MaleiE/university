package com.malei.spring.boot.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public abstract class AbstractNameAndDescriptionObject extends AbstractIdentifiableObject{

    @Column(name = "name_faculty",nullable = false)
    private String name;

    @Column(name = "faculty_description", length = 1000)
    private String description;
}
