package com.example.demo.controller;

import com.example.demo.dto.response.CommonResponse;
import com.example.demo.entity.Pod;
import com.example.demo.service.implementation.PodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pods")
public class PodController {
    @Autowired
    private PodService podService;

    @GetMapping
    public List<Pod> getPods(){
        return  podService.getAll();
    }

    @GetMapping("/{id}")
    public Pod getPodsById(@PathVariable("id") int id){
        return  podService.getById(id);
    }

    @PostMapping
    public ResponseEntity<CommonResponse> addPod(@Valid @RequestBody Pod pod){
        return ResponseEntity.status(HttpStatus.CREATED).body(podService.add(pod));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updatePod(@PathVariable int id, @Valid @RequestBody Pod pod){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(podService.update(id, pod));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deletePod(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(podService.delete(id));
    }
}
