package com.example.logbook3;
public class DetailModel {

    private int person_id;
    private String name, email, birthday;

    public DetailModel(){
        this.person_id = person_id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;

    }

    public int getPerson_id(){
        return person_id;
    }
    public void setPerson_id(int person_id){
        this.person_id = person_id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getBirthday(){
        return birthday;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }


}
