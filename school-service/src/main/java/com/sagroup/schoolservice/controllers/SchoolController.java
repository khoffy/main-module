package com.sagroup.schoolservice.controllers;

import com.sagroup.schoolservice.dtos.SchoolDto;
import com.sagroup.schoolservice.entities.School;
import com.sagroup.schoolservice.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    private SchoolService schoolService;

    @PostMapping
    public ResponseEntity<?> addSchool(@RequestBody SchoolDto schoolDto) {
        SchoolDto response = schoolService.add(schoolDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateSchool(@RequestBody SchoolDto schoolDto) {
        SchoolDto response = schoolService.update(schoolDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{schoolId}")
    public void deleteSchool(@PathVariable String schoolId) {
        schoolService.delete(schoolId);
    }

    @GetMapping
    public ResponseEntity<?> getAllSchool() {
        List<SchoolDto> schoolDtos = schoolService.getAllSchool();
        return new ResponseEntity<>(schoolDtos, HttpStatus.OK);
    }

    @GetMapping("/{schoolId}")
    public ResponseEntity<?> getById(@PathVariable String schoolId) {
        SchoolDto response = schoolService.getById(schoolId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Autowired
    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
}
