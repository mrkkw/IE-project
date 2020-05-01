package com.example.newgame;

public class User {

    String nickname;
    String age;
    String gender;
    String topic;
    String region;

    public User(String nickname,String age, String gender,String topic,String region){
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.topic = topic;
        this.region = region;
    }

    //setter
    public void setAge(String age) {
        this.age = age;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    //getter

    public String getNickname() {
        return nickname;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getTopic() {
        return topic;
    }

    public String getRegion() {
        return region;
    }
}
