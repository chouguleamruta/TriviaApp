package com.example.amruta.triviaapp.Model;

public class History {
    private int ID;
    private String NAME;
    private String QUESTION1;
    private String ANSWER1;
    private String QUESTION2;
    private String ANSWER2;
    public History() {
    }

    public History(String NAME, String QUESTION1, String ANSWER1, String QUESTION2, String ANSWER2) {
        this.NAME = NAME;
        this.QUESTION1 = QUESTION1;
        this.ANSWER1 = ANSWER1;
        this.QUESTION2 = QUESTION2;
        this.ANSWER2 = ANSWER2;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getQUESTION1() {
        return QUESTION1;
    }

    public void setQUESTION1(String QUESTION1) {
        this.QUESTION1 = QUESTION1;
    }

    public String getANSWER1() {
        return ANSWER1;
    }

    public void setANSWER1(String ANSWER1) {
        this.ANSWER1 = ANSWER1;
    }

    public String getQUESTION2() {
        return QUESTION2;
    }

    public void setQUESTION2(String QUESTION2) {
        this.QUESTION2 = QUESTION2;
    }

    public String getANSWER2() {
        return ANSWER2;
    }

    public void setANSWER2(String ANSWER2) {
        this.ANSWER2 = ANSWER2;
    }
}
