package com.chrisloucaides.tartarus.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Students")
public class Student extends User {
    public String relatedAdvisorId;
    public String lastLoginTime;
    public List<String> listOfTaskIds;
    public List<String> listOfMeetingIds;

    public Student(String id, String name, String email, String password, String relatedAdvisorId, String lastLoginTime, List<String> listOfTaskIds, List<String> listOfMeetingIds) {
        super(id, name, email, password);
        this.relatedAdvisorId = relatedAdvisorId;
        this.lastLoginTime = lastLoginTime;
        this.listOfTaskIds = listOfTaskIds;
        this.listOfMeetingIds = listOfMeetingIds;
    }
}
