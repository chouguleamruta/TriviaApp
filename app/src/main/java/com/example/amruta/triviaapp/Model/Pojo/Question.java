package com.example.amruta.triviaapp.Model;

public class Question {
    private int ID;
    private String NAME;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String OPTD;
    private int ANSWER;

    public Question() { }
   /* public Question(String QUESTION, String OPTA, String OPTB, String OPTC, String OPTD, String ANSWER) {
        this.QUESTION = QUESTION;
        this.OPTA = OPTA;
        this.OPTB = OPTB;
        this.OPTC = OPTC;
        this.OPTD = OPTD;
        this.ANSWER = ANSWER;
    }*/


    public Question(String NAME, String QUESTION,int ANSWER ,String OPTA, String OPTB, String OPTC, String OPTD) {
        this.NAME = NAME;
        this.QUESTION = QUESTION;
        this.ANSWER = ANSWER;
        this.OPTA = OPTA;
        this.OPTB = OPTB;
        this.OPTC = OPTC;
        this.OPTD = OPTD;

    }
    public Question( String QUESTION,String OPTA, String OPTB, String OPTC, String OPTD) {

        this.QUESTION = QUESTION;

        this.OPTA = OPTA;
        this.OPTB = OPTB;
        this.OPTC = OPTC;
        this.OPTD = OPTD;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }

    public String getOPTA() {
        return OPTA;
    }

    public void setOPTA(String OPTA) {
        this.OPTA = OPTA;
    }

    public String getOPTB() {
        return OPTB;
    }

    public void setOPTB(String OPTB) {
        this.OPTB = OPTB;
    }

    public String getOPTC() {
        return OPTC;
    }

    public void setOPTC(String OPTC) {
        this.OPTC = OPTC;
    }

    public String getOPTD() {
        return OPTD;
    }

    public void setOPTD(String OPTD) {
        this.OPTD = OPTD;
    }

    public int getANSWER() {
        return ANSWER;
    }

    public void setANSWER(int ANSWER) {
        this.ANSWER = ANSWER;
    }
}
