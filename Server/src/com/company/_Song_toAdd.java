package com.company;

import java.io.Serializable;

public class _Song_toAdd implements Serializable {

    String title;
    String type;
    String duration;
    String singer;
    String stars;

    public _Song_toAdd(String title, String type, String singer, String duration, String stars) {
        this.title=title;
        this.type=type;
        this.singer=singer;
        this.duration=duration;
        this.stars=stars;
        System.out.println(title);
    }
}
