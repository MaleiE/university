package com.malei.spring.boot.repository;

import com.malei.spring.boot.model.AbstractNameAndDescriptionObject;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractNameAndDescriptionRepository<T extends AbstractNameAndDescriptionObject>
        extends AbstractIdRepository<T> {
    T findByName(String name);

}
