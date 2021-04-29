package com.example.onlinevotingsystem.classes;

public class Officer {

    private String Username;
    private String Name;
    private String PhotoURL;
    private int PollNumber;

    public Officer(String username, String name, String photoURL, int pollNumber) {
        Username = username;
        Name = name;
        PhotoURL = photoURL;
        PollNumber = pollNumber;
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

    public int getPollNumber() {
        return PollNumber;
    }

    public void setPollNumber(int pollNumber) {
        PollNumber = pollNumber;
    }
}
