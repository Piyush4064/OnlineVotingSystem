package com.example.onlinevotingsystem.classes;

public class User {

    private String VoterID;
    private String Username;
    private String Name;
    private String PhoneNumber;
    private int PollNumber;
    private long DateOfBirth;
    private long TimeOfRegistration;
    private String PhotoURL;
    private boolean hasVoted;

    public User(String voterID, String username, String name, String phoneNumber, int pollNumber, long dateOfBirth, long timeOfRegistration, String photoURL, boolean hasVoted) {
        VoterID = voterID;
        Username = username;
        Name = name;
        PhoneNumber = phoneNumber;
        PollNumber = pollNumber;
        DateOfBirth = dateOfBirth;
        TimeOfRegistration = timeOfRegistration;
        PhotoURL = photoURL;
        this.hasVoted = hasVoted;
    }

    public String getVoterID() {
        return VoterID;
    }

    public void setVoterID(String voterID) {
        VoterID = voterID;
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

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getPollNumber() {
        return PollNumber;
    }

    public void setPollNumber(int pollNumber) {
        PollNumber = pollNumber;
    }

    public long getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(long dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public long getTimeOfRegistration() {
        return TimeOfRegistration;
    }

    public void setTimeOfRegistration(long timeOfRegistration) {
        TimeOfRegistration = timeOfRegistration;
    }

    public String getPhotoURL() {
        return PhotoURL;
    }

    public void setPhotoURL(String photoURL) {
        PhotoURL = photoURL;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}
