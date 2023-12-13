package com.ljztuimis.bean;

public class ChapterInfo {
    private int chapterId;
    private String chapterName;
    private String studyDate;
    private int studyTime;
    private String chapterDesc;

    public ChapterInfo() {
    }

    public ChapterInfo(int chapterId, String chapterName, String studyDate, int studyTime, String chapterDesc) {
        this.chapterId = chapterId;
        this.chapterName = chapterName;
        this.studyDate = studyDate;
        this.studyTime = studyTime;
        this.chapterDesc = chapterDesc;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getStudyDate() {
        return studyDate;
    }

    public void setStudyDate(String studyDate) {
        this.studyDate = studyDate;
    }

    public int getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(int studyTime) {
        this.studyTime = studyTime;
    }

    public String getChapterDesc() {
        return chapterDesc;
    }

    public void setChapterDesc(String chapterDesc) {
        this.chapterDesc = chapterDesc;
    }
}
