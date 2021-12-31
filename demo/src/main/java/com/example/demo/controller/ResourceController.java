package com.example.demo.controller;

import com.example.demo.dto.response.CommonResponse;
import com.example.demo.entity.Resource;
import com.example.demo.service.implementation.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/resources")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public List<Resource> getResources(){
        return  resourceService.getAll();
    }

    @GetMapping("/{id}")
    public Resource getResourcesById(@PathVariable("id") int id){
        return  resourceService.getById(id);
    }

    @PostMapping
    public ResponseEntity<CommonResponse> addResource(@Valid @RequestBody Resource resource){
        return ResponseEntity.status(HttpStatus.CREATED).body(resourceService.add(resource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updateResource(@PathVariable int id, @Valid @RequestBody Resource resource){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(resourceService.update(id, resource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteResource(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(resourceService.delete(id));
    }
}
