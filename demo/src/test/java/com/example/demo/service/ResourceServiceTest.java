package com.example.demo.service;

import com.example.demo.entity.Pod;
import com.example.demo.entity.Resource;
import com.example.demo.repository.PodRepository;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.implementation.PodService;
import com.example.demo.service.implementation.ResourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceServiceTest {
    @Autowired
    private ResourceService resourceService;
    @MockBean
    private ResourceRepository resourceRepository;

    @Test
    public void getAllTest(){
        when(resourceRepository.findAll()).thenReturn((Stream.of(new Resource(1,"A"),
                new Resource(2, "B"))).collect(Collectors.toList()));
        assertEquals(2, resourceService.getAll().size());
    }

    @Test
    public void getByIdTest(){
        int id = 1;
        Resource resource = new Resource(1, "A");
        when(resourceRepository.findById(id)).thenReturn(java.util.Optional.of(resource));
        assertEquals(1, resourceService.getById(id).getId());
    }

    @Test
    public void updateTest(){
        int id = 1;
        Resource resource = new Resource(1, "A");
        when(resourceRepository.save(resource)).thenReturn(resource);
        assertEquals(202, resourceService.update(id, resource).getHttpStatus());
    }
}
