package com.chrisloucaides.tartarus.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Advisors")
public class Advisor extends User {
    public List<String> listOfStudentIds;
    public List<String> listOfMeetingIds;

    public Advisor(String id, String name, String email, String password, List<String> listOfStudentIds, List<String> listOfMeetingIds) {
        super(id, name, email, password);
        this.listOfStudentIds = listOfStudentIds;
        this.listOfMeetingIds = listOfMeetingIds;
    }
}

