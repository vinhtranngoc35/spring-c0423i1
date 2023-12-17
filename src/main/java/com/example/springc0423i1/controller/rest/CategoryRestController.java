package com.example.springc0423i1.controller.rest;

import com.example.springc0423i1.repository.CategoryRepository;
import com.example.springc0423i1.service.dto.SelectOptionResponse;
import com.example.springc0423i1.util.AppUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("api/categories")
@CrossOrigin(origins = {"http://localhost:5173"})
public class CategoryRestController {
    private final CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(categoryRepository.findAll().stream().map(e -> AppUtil.mapper.map(e, SelectOptionResponse.class)).collect(Collectors.toList()), HttpStatus.OK);
    }
}