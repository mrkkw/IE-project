package com.example.newgame;

public class User {

    String nickname;
    String age;
    String gender;
    String topic;

    public User(String nickname,String age, String gender,String topic){
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.topic = topic;
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
}
