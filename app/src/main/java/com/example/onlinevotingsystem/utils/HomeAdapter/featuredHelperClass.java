package com.example.onlinevotingsystem.utils.HomeAdapter;

public class featuredHelperClass {

    int image;
    String name, info;

    public featuredHelperClass(int image, String name, String info) {
        this.image = image;
        this.name = name;
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}
