package com.company.coursemanagement.presentation.controller;

import com.company.coursemanagement.application.dto.StudentDTO;
import com.company.coursemanagement.application.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO dto) {
        StudentDTO created = studentService.create(dto);
        return ResponseEntity.created(URI.create("/api/students/" + created.getId())).body(created);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable Long id, @Valid @RequestBody StudentDTO dto) {
        return ResponseEntity.ok(studentService.update(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDTO> partialUpdate(@PathVariable Long id, @RequestBody StudentDTO dto) {
        return ResponseEntity.ok(studentService.partialUpdate(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}