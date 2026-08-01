package com.company.coursemanagement.domain.exception;

public class DuplicateEnrollmentException extends BusinessException {

    public DuplicateEnrollmentException(Long studentId, Long courseId) {
        super("Estudiante " + studentId + " ya se encuentra activo en el curso " + courseId);
    }
}
