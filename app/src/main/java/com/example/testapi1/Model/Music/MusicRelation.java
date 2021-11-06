package com.example.testapi1.Model.Music;

import java.util.List;

public class MusicRelation {
    private int err;
    private String msg;
    private List<Item> itemList;
    private long timestamp;

    public MusicRelation(int err, String msg, List<Item> itemList, long timestamp) {
        this.err = err;
        this.msg = msg;
        this.itemList = itemList;
        this.timestamp = timestamp;
    }

    public MusicRelation() {
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "MusicRelation{" +
                "err=" + err +
                ", msg='" + msg + '\'' +
                ", itemList=" + itemList +
                ", timestamp=" + timestamp +
                '}';
    }
}
