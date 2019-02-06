package com.example.saif.wallpaperxi;

import java.security.PrivateKey;

public class ListItem {

    private String name;
    private String  url;

    public ListItem(String name,String url) {
        this.name = name;
        this.url=url;

    }


    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
