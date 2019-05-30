package com.company;

import java.io.Serializable;

//Θάνος Καψάλης 321/2015088

public class _Song_toAdd implements Serializable {

    String title;
    String type;
    String duration;
    String singer;
    int stars;

    public _Song_toAdd(String title, String type, String singer, String duration, int stars) {
        this.title = title;
        this.type = type;
        this.singer = singer;
        this.duration = duration;
        this.stars = stars;
        System.out.println(title);
    }


    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getDuration() {
        return duration;
    }

    public String getSinger() {
        return singer;
    }

    public int getStars() {
        return stars;
    }
}
