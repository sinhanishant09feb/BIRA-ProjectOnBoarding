package com.example.demo.service;

import com.example.demo.entity.Pod;
import com.example.demo.entity.Resource;
import com.example.demo.repository.PodRepository;
import com.example.demo.service.implementation.PodService;
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
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PodServiceTest {
    @Autowired
    private PodService podService;
    @MockBean
    private PodRepository podRepository;

    @Test
    public void getAllTest(){
        when(podRepository.findAll()).thenReturn((Stream.of(new Pod(1,"A",
                "A", "A"), new Pod(2, "B", "B", "B")))
                .collect(Collectors.toList()));
        assertEquals(2, podService.getAll().size());
    }

    @Test
    public void getByIdTest(){
        int id = 1;
        Pod pod = new Pod(1, "A", "A", "A");
        when(podRepository.findById(id)).thenReturn(java.util.Optional.of(pod));
        assertEquals(1, podService.getById(id).getId());
    }

    @Test
    public void updateTest(){
        List<Resource> emptyList = Collections.emptyList();
        int id = 1;
        Pod pod = new Pod(id, "A", "A", "A", emptyList);
        when(podRepository.save(pod)).thenReturn(pod);
        assertEquals(202, podService.update(id, pod).getHttpStatus());
    }
}
