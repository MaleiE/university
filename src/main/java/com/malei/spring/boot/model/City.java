package com.malei.spring.boot.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class City extends AbstractNameAndDescriptionObject {
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    private Street street;
}
