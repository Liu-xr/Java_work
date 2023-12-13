package com.ljztuimis.bean;

public class ObjectiveInfo {
    private int objectiveId;
    private String objectiveContent;

    public ObjectiveInfo() {
    }

    public ObjectiveInfo(int objectiveId, String objectiveContent) {
        this.objectiveId = objectiveId;
        this.objectiveContent = objectiveContent;
    }

    public int getObjectiveId() {
        return objectiveId;
    }

    public void setObjectiveId(int objectiveId) {
        this.objectiveId = objectiveId;
    }

    public String getObjectiveContent() {
        return objectiveContent;
    }

    public void setObjectiveContent(String objectiveContent) {
        this.objectiveContent = objectiveContent;
    }
}
