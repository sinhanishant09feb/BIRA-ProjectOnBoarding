package com.example.demo.service.interfaces;

import com.example.demo.dto.response.CommonResponse;
import java.util.List;

public interface CrudOperations<T> {
    List<T> getAll();
    T getById(int id);
    CommonResponse add(T t);
    CommonResponse update(int id, T t);
    CommonResponse delete(int id);
}
