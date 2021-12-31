package com.example.demo.service.implementation;

import com.example.demo.BiraEnum;
import com.example.demo.dto.response.CommonResponse;
import com.example.demo.entity.Pod;
import com.example.demo.repository.PodRepository;
import com.example.demo.service.interfaces.CrudOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PodService implements CrudOperations<Pod> {
    @Autowired
    private PodRepository podRepository;

    /**
     * <summary> Gets All from Pod Table
     * </summary>
     * <param></param>
     * <returns>List = Pod</returns>
     **/
    @Override
    public List<Pod> getAll() {
        return podRepository.findAll();
    }

    /**
     * <summary> Gets from Pod Table with Id
     * </summary>
     * <param int = id></param>
     * <returns>pod = Pod</returns>
     */
    @Override
    public Pod getById(int id) {
        Optional<Pod> pod;
        pod = podRepository.findById(id);
        if(pod.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(BiraEnum.User_with_id.name() +
                        "%d" + BiraEnum.not_found.name(), id));
        return new Pod(pod.get().getId(), pod.get().getPodName(), pod.get().getProjectName(),
                pod.get().getPodManager(), pod.get().getResourceList());
    }

    /**
     * <summary> Adds a pod into Pod Table
     * </summary>
     * <param Pod = pod></param>
     * <returns>CommonResponse = commonResponse</returns>
     */
    @Override
    public CommonResponse add(Pod pod) {
        Pod oPod = podRepository.save(new Pod(pod.getPodName(), pod.getProjectName(), pod.getPodManager(),
                pod.getResourceList()));
        return new CommonResponse(201, BiraEnum.Created.name(), BiraEnum.A_pod_is_created.name(),
                oPod.getId(), LocalDateTime.now());
    }

    /**
     * <summary> Updates pod  from Pod Table using id
     * </summary>
     * <param int = id, Pod = pod></param>
     * <returns>CommonResponse = commonResponse</returns>
     */
    @Override
    public CommonResponse update(int id, Pod pod) {
        Pod podd = podRepository.save(new Pod(id, pod.getPodName(), pod.getProjectName(), pod.getPodManager(),
                pod.getResourceList()));
        return new CommonResponse(202, BiraEnum.Updated.name(), BiraEnum.The_pod_is_updated.name(), id,
                LocalDateTime.now());
    }

    /**
     * <summary> Deletes from Pod Table with id
     * </summary>
     * <param int = id></param>
     * <returns>CommonResponse = commonResponse</returns>
     */
    @Override
    public CommonResponse delete(int id) {
        podRepository.deleteById(id);
        return new CommonResponse(204, BiraEnum.Deleted.name(),BiraEnum.The_pod_is_deleted.name(), id,
                LocalDateTime.now());
    }
}
