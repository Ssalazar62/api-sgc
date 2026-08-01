package com.company.coursemanagement.domain.exception;

public class CourseNotFoundException extends BusinessException {

    public CourseNotFoundException(Long id) {
        super("No se encuentra el Curso: " + id);
    }
}
