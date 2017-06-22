package com.malei.spring.boot.repository;

import com.malei.spring.boot.model.AbstractIdentifiableObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public  interface AbstractIdRepository<T extends AbstractIdentifiableObject>
        extends JpaRepository<T,Long> {
    T findById(Long id);
}
