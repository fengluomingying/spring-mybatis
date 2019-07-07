package com.mooc.mybatis.bean;

public class Yuer {
    Integer id;
    String questionTitle;
    String questionDetail;
    String questionAuthor;
    String questionCategories;
    String questionAnswer;

    public Yuer(Integer id, String questionTitle, String questionDetail, String questionAuthor, String questionCategories, String questionAnswer) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionDetail = questionDetail;
        this.questionAuthor = questionAuthor;
        this.questionCategories = questionCategories;
        this.questionAnswer = questionAnswer;
    }

    public Yuer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionDetail() {
        return questionDetail;
    }

    public void setQuestionDetail(String questionDetail) {
        this.questionDetail = questionDetail;
    }

    public String getQuestionAuthor() {
        return questionAuthor;
    }

    public void setQuestionAuthor(String questionAuthor) {
        this.questionAuthor = questionAuthor;
    }

    public String getQuestionCategories() {
        return questionCategories;
    }

    public void setQuestionCategories(String questionCategories) {
        this.questionCategories = questionCategories;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    @Override
    public String toString() {
        return "Yuer{" +
                "id=" + id +
                ", questionTitle='" + questionTitle + '\'' +
                ", questionDetail='" + questionDetail + '\'' +
                ", questionAuthor='" + questionAuthor + '\'' +
                ", questionCategories='" + questionCategories + '\'' +
                ", questionAnswer='" + questionAnswer + '\'' +
                '}';
    }


}
