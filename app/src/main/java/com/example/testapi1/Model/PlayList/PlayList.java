package com.example.testapi1.Model.PlayList;

import com.example.testapi1.Model.Music.Item;

import java.util.List;

public class PlayList {
    private String id;
    private String name;
    private List<Item> idOfMusic;

    public PlayList(String id, String name, List<Item> idOfMusic) {
        this.id = id;
        this.name = name;
        this.idOfMusic = idOfMusic;
    }

    public PlayList() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getIdOfMusic() {
        return idOfMusic;
    }

    public void setIdOfMusic(List<Item> idOfMusic) {
        this.idOfMusic = idOfMusic;
    }
}
