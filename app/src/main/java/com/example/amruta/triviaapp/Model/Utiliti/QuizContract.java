package com.example.amruta.triviaapp.Model.Utiliti;

import android.provider.BaseColumns;

public class QuizContract {
    public QuizContract() {
    }

    public static class MovieEntry implements BaseColumns {
        //table name
        public static final String TABLE_QUEST = "quest";
        // Table Columns names
        public static final String KEY_ID = "id";
        public static final String KEY_NAME = "name";
        public static final String KEY_QUES = "question";
        public static final String KEY_ANSWER = "answer"; //correct option
        public static final String KEY_OPTA= "opta"; //option a
        public static final String KEY_OPTB= "optb"; //option b
        public static final String KEY_OPTC= "optc";//option c
        public static final String KEY_OPTD= "optd";//option d

        //table summery & it's column names
        //table name
        public static final String TABLE_SUMMERY = "summery";
        //columns name
        public static final String KEY_SID = "id";
        public static final String KEY_SNAME = "name";
        public static final String KEY_SQUES1 = "question1";
        public static final String KEY_SANSWER1 = "answer1";
        public static final String KEY_SQUES2 = "question2";
        public static final String KEY_SANSWER2 = "answer2";
    }
}
