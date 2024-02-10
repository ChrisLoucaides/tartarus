package com.chrisloucaides.tartarus.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Students")
public class Student extends User {
    private String relatedAdvisorId;
    private String lastLoginTime;
    private List<String> listOfTaskIds;
    private List<String> listOfMeetingIds;

    public Student(String id, String name, String email, String password, String relatedAdvisorId, String lastLoginTime, List<String> listOfTaskIds, List<String> listOfMeetingIds) {
        super(id, name, email, password);
        this.relatedAdvisorId = relatedAdvisorId;
        this.lastLoginTime = lastLoginTime;
        this.listOfTaskIds = listOfTaskIds;
        this.listOfMeetingIds = listOfMeetingIds;
    }

    public String relatedAdvisorId() {
        return relatedAdvisorId;
    }

    public void setRelatedAdvisorId(String relatedAdvisorId) {
        this.relatedAdvisorId = relatedAdvisorId;
    }

    public String lastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public List<String> listOfTaskIds() {
        return listOfTaskIds;
    }

    public void setListOfTaskIds(List<String> listOfTaskIds) {
        this.listOfTaskIds = listOfTaskIds;
    }

    public List<String> listOfMeetingIds() {
        return listOfMeetingIds;
    }

    public void setListOfMeetingIds(List<String> listOfMeetingIds) {
        this.listOfMeetingIds = listOfMeetingIds;
    }
}
