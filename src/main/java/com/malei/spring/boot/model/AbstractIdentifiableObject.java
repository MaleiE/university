package com.malei.spring.boot.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EqualsAndHashCode
public abstract class AbstractIdentifiableObject {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;
}
