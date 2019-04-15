package com.example.amruta.triviaapp.Contoller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.amruta.triviaapp.Model.History;
import com.example.amruta.triviaapp.Model.Question;

import java.util.ArrayList;
import java.util.List;

import static com.example.amruta.triviaapp.Model.Utiliti.QuizContract.MovieEntry.KEY_ANSWER;
import static com.example.amruta.triviaapp.Model.Utiliti.QuizContract.MovieEntry.KEY_ID;
import static com.example.amruta.triviaapp.Model.Utiliti.QuizContract.MovieEntry.KEY_NAME;
import static com.example.amruta.triviaapp.Model.Utiliti.QuizContract.MovieEntry.KEY_OPTA;
import static com.example.amruta.triviaapp.Model.Utiliti.QuizContract.MovieEntry.KEY_OPTB;
import static com.example.amruta.triviaapp.Model.Utiliti.QuizContract.MovieEntry.KEY_OPTC;
import static com.example.amruta.triviaapp.Model.Utiliti.QuizContract.MovieEntry.KEY_OPTD;
import static com.example.amruta.triviaapp.Model.Utiliti.QuizContract.MovieEntry.KEY_QUES;
import static com.example.amruta.triviaapp.Model.Utiliti.QuizContract.MovieEntry.TABLE_QUEST;
import static com.example.amruta.triviaapp.Model.Utiliti.QuizContract.MovieEntry.*;
public class DbHelper extends SQLiteOpenHelper {
    // Database Name
    private static final int DATABASE_VERSION = 1;
    // tasks table name
    private static final String DATABASE_NAME = "triviaQuiz";
    private SQLiteDatabase db;

    public DbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
         this.db = db;
        final String sql = "CREATE TABLE " +
               TABLE_QUEST + " ( " +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_NAME + " TEXT, " +
                KEY_QUES + " TEXT, " +
                KEY_ANSWER + " TEXT, " +
                KEY_OPTA + " TEXT, " +
                KEY_OPTB + " TEXT, " +
                KEY_OPTC + " TEXT, " +
                KEY_OPTD + " TEXT " +
                ")";
        db.execSQL(sql);
        addQuestions();
        final String sql_1 = "CREATE TABLE " +
                TABLE_SUMMERY + " ( " +
                KEY_SID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_SNAME + " TEXT, " +
                KEY_SQUES1 + " TEXT, " +
                KEY_SANSWER1 + " TEXT, " +
                KEY_SQUES2 + " TEXT, " +
                KEY_SANSWER2 + " TEXT " +
                ")";

        db.execSQL(sql_1);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
// Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SUMMERY);
        // Create tables again
        onCreate(sqLiteDatabase);
    }
    private void addQuestions()
    {
        Question q1=new Question("Who is the best cricketer in the world ?", "Sachine Tendulker ", "Virat Kolli", "AdamGilchirst","Jacques Kallis");
        addQuestion(q1);
        Question q2=new Question("What are the colors in the Indian national flag ?",  "White", "Yellow", "Orange","Green");
        addQuestion(q2);

    }
    // Adding new question
    public void addQuestion(Question question) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, question.getNAME());
        values.put(KEY_QUES, question.getQUESTION());
        values.put(KEY_ANSWER, question.getANSWER());
        values.put(KEY_OPTA, question.getOPTA());
        values.put(KEY_OPTB, question.getOPTB());
        values.put(KEY_OPTC, question.getOPTC());
        values.put(KEY_OPTD, question.getOPTD());
        // Inserting Row
        db.insert(TABLE_QUEST, null, values);
    }
    public void addHistory(History history){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_SNAME,history.getNAME());
        values.put(KEY_SQUES1,history.getQUESTION1());
        values.put(KEY_SANSWER1,history.getANSWER1());
        values.put(KEY_SQUES2,history.getQUESTION2());
        values.put(KEY_SANSWER2,history.getANSWER2());
        db.insert(TABLE_SUMMERY, null, values);

    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList< >();
        db = getReadableDatabase();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();

                quest.setNAME(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                quest.setQUESTION(cursor.getString(cursor.getColumnIndex(KEY_QUES)));
                quest.setANSWER(cursor.getInt(cursor.getColumnIndex(KEY_ANSWER)));
                quest.setOPTA(cursor.getString(cursor.getColumnIndex(KEY_OPTA)));
                quest.setOPTB(cursor.getString(cursor.getColumnIndex(KEY_OPTB)));
                quest.setOPTC(cursor.getString(cursor.getColumnIndex(KEY_OPTC)));
                quest.setOPTD(cursor.getString(cursor.getColumnIndex(KEY_OPTD)));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        cursor.close();
        return quesList;
    }
    public List<History> getAllHistory() {
        List<History> historyList = new ArrayList< >();
        db = getReadableDatabase();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SUMMERY;
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                History history = new History();
                history.setNAME(cursor.getString(cursor.getColumnIndex(KEY_SNAME)));
                history.setQUESTION1(cursor.getString(cursor.getColumnIndex(KEY_SQUES1)));
                history.setANSWER1(cursor.getString(cursor.getColumnIndex(KEY_SANSWER1)));
                history.setQUESTION2(cursor.getString(cursor.getColumnIndex(KEY_SQUES2)));
                history.setANSWER2(cursor.getString(cursor.getColumnIndex(KEY_SANSWER2)));
                historyList.add(history);
            } while (cursor.moveToNext());
        }
        // return quest list
        cursor.close();
        return historyList;
    }

    public int rowCount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }


}
