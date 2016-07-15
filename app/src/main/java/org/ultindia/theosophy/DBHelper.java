package org.ultindia.theosophy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srikanta on 15/7/16.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "theosophy";

    // Contacts table name
    private static final String TABLE_QUOTES = "quotes";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_QUOTE = "quote";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_QUOTES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_AUTHOR + " TEXT,"
                + KEY_QUOTE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    public void addQuote(Quote quote) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_AUTHOR, quote.getAuthor());
        values.put(KEY_QUOTE, quote.getQuote());

        // Inserting Row
        db.insert(TABLE_QUOTES, null, values);
        db.close();
    }

    public Quote getQuote(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_QUOTES, new String[] { KEY_ID,
                        KEY_AUTHOR, KEY_QUOTE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Quote quote = new Quote(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return quote;
    }

    public List<Quote> getAllQuotes() {

        List<Quote> quotesList = new ArrayList<Quote>();

        String selectQuery = "SELECT  * FROM " + TABLE_QUOTES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Quote q = new Quote();
                q.setId(Integer.parseInt(cursor.getString(0)));
                q.setAuthor(cursor.getString(1));
                q.setQuote(cursor.getString(2));
                // Adding contact to list
                quotesList.add(q);
            } while (cursor.moveToNext());
        }

        // return contact list
        return quotesList;
    }

    public int getQuotesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_QUOTES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public void deleteContact(Quote quote) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_QUOTES, KEY_ID + " = ?",
                new String[] { String.valueOf(quote.getId()) });
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUOTES);
        onCreate(db);
    }
}
