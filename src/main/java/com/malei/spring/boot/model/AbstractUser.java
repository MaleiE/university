package com.malei.spring.boot.model;

import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@MappedSuperclass
public class AbstractUser extends AbstractNameAndDescriptionObject{
    private String lastName;
    private String middleName;
    @Email
    private String email;

}
