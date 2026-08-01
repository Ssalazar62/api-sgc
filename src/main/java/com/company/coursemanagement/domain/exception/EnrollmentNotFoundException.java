package com.company.coursemanagement.domain.exception;

public class EnrollmentNotFoundException extends BusinessException {

    public EnrollmentNotFoundException(Long id) {
        super("Inscripción no encontrada " + id);
    }
}
