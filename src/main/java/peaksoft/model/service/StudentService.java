package peaksoft.model.service;

import peaksoft.model.model.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);

    void update(Student student);

    Student getById(Long id);

    List<Student> getAll();

    void removeStudent(Student student);
}

