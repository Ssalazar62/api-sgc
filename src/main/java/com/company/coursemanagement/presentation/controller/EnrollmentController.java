package com.company.coursemanagement.presentation.controller;

import com.company.coursemanagement.application.dto.EnrollmentDTO;
import com.company.coursemanagement.application.service.EnrollmentService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> enroll(@RequestParam @NotNull Long studentId,
                                                @RequestParam @NotNull Long courseId) {
        EnrollmentDTO created = enrollmentService.enrollStudent(studentId, courseId);
        return ResponseEntity.created(URI.create("/api/enrollments/" + created.getId())).body(created);
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> findAll() {
        return ResponseEntity.ok(enrollmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        enrollmentService.cancelEnrollment(id);
        return ResponseEntity.noContent().build();
    }
}