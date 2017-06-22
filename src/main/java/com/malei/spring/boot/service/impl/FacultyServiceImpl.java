package com.malei.spring.boot.service.impl;

import com.malei.spring.boot.model.Faculty;
import com.malei.spring.boot.repository.FacultyRepository;
import com.malei.spring.boot.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public void addFaculty(Faculty faculty) {
        facultyRepository.saveAndFlush(faculty);
    }

    @Override
    public void deleteFaculty(Faculty faculty) {
        facultyRepository.delete(faculty);
    }

    @Override
    public Faculty getByName(String name) {
        return facultyRepository.findByName(name);
    }

    @Override
    public void editFaculty(Faculty faculty) {
        facultyRepository.saveAndFlush(faculty);
    }

    @Override
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getById(Long id) {
        return facultyRepository.findById(id);
    }
}
