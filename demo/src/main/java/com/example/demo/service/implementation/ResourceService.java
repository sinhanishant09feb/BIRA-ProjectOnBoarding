package com.example.demo.service.implementation;

import com.example.demo.BiraEnum;
import com.example.demo.dto.response.CommonResponse;
import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.interfaces.CrudOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceService implements CrudOperations<Resource> {

    @Autowired
    private ResourceRepository resourceRepository;

    /**
     * <summary> Gets All from Resource Table
     * </summary>
     * <param></param>
     * <returns>List = Resource</returns>
     */
    @Override
    public List<Resource> getAll() {
        return resourceRepository.findAll();
    }

    /**
     * <summary> Gets from Resource Table with id
     * </summary>
     * <param int = id></param>
     * <returns>Resource = resource</returns>
     */
    @Override
    public Resource getById(int id) {
        Optional<Resource> resource;
        resource = resourceRepository.findById(id);
        if(resource.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(BiraEnum.User_with_id.name() +
                    "%d" + BiraEnum.not_found.name(), id));
        return new Resource(resource.get().getId(), resource.get().getName());
    }

    /**
     * <summary> Adds into Resource Table
     * </summary>
     * <param resource = Resource></param>
     * <returns>CommonResponse = commonResponse</returns>
     */
    @Override
    public CommonResponse add(Resource resource) {
        Resource oResource = resourceRepository.save(new Resource(resource.getId(), resource.getName()));
        return new CommonResponse(201, BiraEnum.Created.name(), BiraEnum.A_pod_is_created.name(),
                oResource.getId(), LocalDateTime.now());
    }

    /**
     * <summary> Updates into Resource Table
     * </summary>
     * <param int = id, Resource = resource></param>
     * <returns>CommonResponse = commonResponse</returns>
     */
    @Override
    public CommonResponse update(int id, Resource resource) {
        Resource res = resourceRepository.save(new Resource(id, resource.getName()));
        return new CommonResponse(202, BiraEnum.Updated.name(), BiraEnum.The_pod_is_updated.name(), id,
                LocalDateTime.now());
    }

    /**
     * <summary> Delete from Resource Table
     * </summary>
     * <param int = id></param>
     * <returns>CommonResponse = commonResponse</returns>
     */
    @Override
    public CommonResponse delete(int id) {
        resourceRepository.deleteById(id);
        return new CommonResponse(204, BiraEnum.Deleted.name(), BiraEnum.The_pod_is_deleted.name(), id,
                LocalDateTime.now());
    }
}
