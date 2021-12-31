package com.app.nbm.model;

/**
 * Created by Lincoln on 18/05/16.
 */
public class HomeInfo {
    private String name;
    private int numOfSongs;
    private int thumbnail;

    public HomeInfo() {
    }

    public HomeInfo(String name, int numOfSongs, int thumbnail) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public HomeInfo(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public HomeInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
