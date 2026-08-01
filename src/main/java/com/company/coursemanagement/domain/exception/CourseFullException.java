package com.company.coursemanagement.domain.exception;

public class CourseFullException extends BusinessException {

    public CourseFullException(Long courseId) {
        super("El curso tiene su capacidad máxima: " + courseId);
    }
}
