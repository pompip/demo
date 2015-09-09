package me.liukc.cpr095.demo4.dao;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/**
 * Author :liukechong
 * Date : 2015-08-26
 * FIXME
 * Todo
 */
public class DataBaseControl extends ContentProvider {


    DatabaseHelpter mDatabaseHelpter;

    @Override
    public boolean onCreate() {
        mDatabaseHelpter = new DatabaseHelpter(getContext(), "mydatabase", null, 1);
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
