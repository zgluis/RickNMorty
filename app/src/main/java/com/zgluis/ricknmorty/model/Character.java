package com.zgluis.ricknmorty.model;

import java.util.List;

import lombok.Data;

@Data
public class Character {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private Location location;
    private String image;
    private List<String> episode = null;
    private String url;
    private String created;
}
