package com.lectopia.tsop.booklibrarydemo.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lectopia.tsop.booklibrarydemo.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDb {
    private static final String TABLE_NAME = "book";
    private SQLiteDatabase db;

    public BookDb(SQLiteDatabase db) {
        this.db = db;
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME
        + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "title TEXT, "
                + "author TEXT, "
                + "content TEXT)");
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public int insertRecordParam(String title, String author, String content) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("author", author);
        contentValues.put("content", content);
        return (int) db.insert(TABLE_NAME, null, contentValues);
    }

    public List<Book> selectAll() {
        String sql = "SELECT _id, title, author, content FROM " + TABLE_NAME;
        Cursor c= db.rawQuery(sql, null);
        int count = c.getCount();
        List<Book> result = new ArrayList<Book>();
        while(c.moveToNext()) {
            Book book = new Book();
            book.setId(c.getInt(0));
            book.setTitle(c.getString(1));
            book.setAuthor(c.getString(2));
            book.setContent(c.getString(3));
            result.add(book);
        }
        return result;
    }
}
