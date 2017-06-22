package com.malei.spring.boot.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "groups")
public class Groups extends AbstractNameAndDescriptionObject {
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;
}
