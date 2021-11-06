package com.example.testapi1.Model.Music;

import com.example.testapi1.Model.Artist.Singer;

public class Item {
    private String id;
    private String name;
    private String code;
    private String playlist_id;
    private Singer singer;
    private String artists_names;
    private String performer;
    private String link;
    private String thumbnail;
    private int duration;


    public Item(String id, String name, String code, String playlist_id, Singer singer, String artists_names, String performer, String link, String thumbnail, int duration) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.playlist_id = playlist_id;
        this.singer = singer;
        this.artists_names = artists_names;
        this.performer = performer;
        this.link = link;
        this.thumbnail = thumbnail;
        this.duration = duration;
    }

    public Item() {
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

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(String playlist_id) {
        this.playlist_id = playlist_id;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getArtists_names() {
        return artists_names;
    }

    public void setArtists_names(String artists_names) {
        this.artists_names = artists_names;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + performer + '\'' +
                ", code='" + code + '\'' +
                ", playlist_id='" + playlist_id + '\'' +
                ", singer=" + singer.toString() +
                ", artists_names='" + artists_names + '\'' +
                ", link='" + link + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", duration=" + duration +
                '}';
    }
}
