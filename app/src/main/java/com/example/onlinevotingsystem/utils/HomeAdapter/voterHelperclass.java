package com.example.onlinevotingsystem.utils.HomeAdapter;

public class voterHelperclass {

    int voter_image;
    String name, data;

    public voterHelperclass(int image, String name, String info) {
        this.voter_image = image;
        this.name = name;
        this.data = info;
    }

    public int getImage() {
        return voter_image;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return data;
    }
}