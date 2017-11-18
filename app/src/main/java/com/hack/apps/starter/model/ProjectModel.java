package com.hack.apps.starter.model;

public class ProjectModel {
    private int id;
    private String name;
    private String description;
    private String imageUri;

    public ProjectModel(int id, String name, String description, String imageUri) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUri = imageUri;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUri() {
        return imageUri;
    }

    @Override
    public String toString() {
        return "ProjectModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUri='" + imageUri + '\'' +
                '}';
    }
}
