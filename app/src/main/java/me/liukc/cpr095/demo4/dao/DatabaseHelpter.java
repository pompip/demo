package me.liukc.cpr095.demo4.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Author :liukechong
 * Date : 2015-08-26
 * FIXME
 * Todo
 */
public class DatabaseHelpter extends SQLiteOpenHelper {
    public DatabaseHelpter(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table test_table (_id integer primary key,order_id text,order_message text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
