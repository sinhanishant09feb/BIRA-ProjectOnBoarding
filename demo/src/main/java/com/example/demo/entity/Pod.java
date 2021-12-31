package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Pod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String podName;
    private String projectName;
    private String podManager;
    @OneToMany(targetEntity = Resource.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "podFk", referencedColumnName = "id")
    private List<Resource> resourceList;

    public Pod(int id, String podName, String projectName, String podManager, List<Resource> resourceList) {
        this.id = id;
        this.podName = podName;
        this.projectName = projectName;
        this.podManager = podManager;
        this.resourceList = resourceList;
    }

    public Pod(String podName, String projectName, String podManager, List<Resource> resourceList) {
        this.podName = podName;
        this.projectName = projectName;
        this.podManager = podManager;
        this.resourceList = resourceList;
    }

    public Pod(int id, String podName, String projectName, String podManager) {
        this.id = id;
        this.podName = podName;
        this.projectName = projectName;
        this.podManager = podManager;
    }

    public Pod(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPodName() {
        return podName;
    }

    public void setPodName(String podName) {
        this.podName = podName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPodManager() {
        return podManager;
    }

    public void setPodManager(String podManager) {
        this.podManager = podManager;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
}
