package com.example.testapi1.Model.Artist;

public class Singer {
    private String name;
    private String link;

    public Singer(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public Singer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
