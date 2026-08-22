package com.company.coursemanagement.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CourseDTO {

    private Long id;

    @NotBlank(message = "El código del curso es obligatorio.")
    private String code;

    @NotBlank(message = "El nombre del curso es obligatorio.")
    private String name;

    private String description;

    @NotNull(message = "La capacidad máxima es obligatoria.")
    @Positive(message = "La capacidad máxima debe ser mayor a cero.")
    private Integer maxCapacity;

    public CourseDTO() {
    }

    public CourseDTO(Long id, String code, String name, String description, Integer maxCapacity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.maxCapacity = maxCapacity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(Integer maxCapacity) { this.maxCapacity = maxCapacity; }
}