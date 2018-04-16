package com.example.digitalegyptlenovo.movieapp.sqlite.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.digitalegyptlenovo.movieapp.sqlite.helper.FeedGenreHelper.FeedEntry;

import java.util.ArrayList;

/**
 * Created by Mohamed Elshafey on 4/11/2018.
 */
public class GenreSqlHelper {
    private static GenreSqlHelper instance;
    private SQLiteDatabase db;

    private GenreSqlHelper(Context context) {
        FeedGenreHelper mDbHelper = new FeedGenreHelper(context);
        db = mDbHelper.getWritableDatabase();
    }

    public static GenreSqlHelper getInstance(Context context) {
        if (instance == null)
            instance = new GenreSqlHelper(context);

        return instance;
    }

    public void addNewGenre(int id, String name) {
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_ID, id);
        values.put(FeedEntry.COLUMN_NAME_NAME, name);

        db.insert(FeedEntry.TABLE_NAME, null, values);
    }

    public ArrayList<String> getGenreNamesByIds(String[] selectionGenreIds) {

        String selection = getSelectionString(selectionGenreIds.length);

        String sortOrder = FeedEntry.COLUMN_NAME_NAME + " DESC";

        Cursor cursor = db.query(FeedEntry.TABLE_NAME, null, selection, selectionGenreIds,
                null, null, sortOrder);

        ArrayList<String> matchedGenresNames = new ArrayList<>();

        while (cursor.moveToNext()) {
            String genreName = cursor.getString(cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_NAME));

            matchedGenresNames.add(genreName);
        }

        cursor.close();

        return matchedGenresNames;
    }

    private String getSelectionString(int length) {
        String selection = "";
        for (int i = 0; i < length; i++) {
            selection = selection.concat(FeedEntry.COLUMN_NAME_ID) + " = ? ";
            if (i != length - 1)
                selection = selection.concat(" OR ");
        }
        return selection;
    }

    public boolean isTableEmpty() {
        String count = "SELECT count(*) FROM " + FeedEntry.TABLE_NAME;
        Cursor mCursor = db.rawQuery(count, null);
        mCursor.moveToFirst();
        int iCount = mCursor.getInt(0);
        mCursor.close();
        return iCount <= 0;
    }
}
