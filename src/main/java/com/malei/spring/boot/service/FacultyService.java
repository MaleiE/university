package com.malei.spring.boot.service;

import com.malei.spring.boot.model.Faculty;

import java.util.List;

public interface FacultyService {
    void addFaculty(Faculty faculty);
    void deleteFaculty(Faculty id);
    Faculty getByName(String name);
    void editFaculty(Faculty faculty);
    List<Faculty> getAll();
    Faculty getById(Long id);
}
