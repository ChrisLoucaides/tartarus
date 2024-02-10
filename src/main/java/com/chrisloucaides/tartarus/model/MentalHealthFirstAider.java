package com.chrisloucaides.tartarus.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Mental Health First Aiders")
public class MentalHealthFirstAider extends User {
    public List<String> listOfStudentIds;

    public MentalHealthFirstAider(String id, String name, String email, String password, List<String> listOfStudentIds) {
        super(id, name, email, password);
        this.listOfStudentIds = listOfStudentIds;
    }

    public List<String> listOfStudentIds() {
        return listOfStudentIds;
    }

    public void setListOfStudentIds(List<String> listOfStudentIds) {
        this.listOfStudentIds = listOfStudentIds;
    }
}

