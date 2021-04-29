package com.example.onlinevotingsystem.classes;

public class Admin {

    private String Username;
    private String Name;
    private String PhotoURL;

    public Admin(String username, String name, String photoURL) {
        Username = username;
        Name = name;
        PhotoURL = photoURL;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhotoURL() {
        return PhotoURL;
    }

    public void setPhotoURL(String photoURL) {
        PhotoURL = photoURL;
    }
}
