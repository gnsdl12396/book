package com.lectopia.tsop.booklibrarydemo.share;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.lectopia.tsop.booklibrarydemo.db.BookDb;
import com.lectopia.tsop.booklibrarydemo.model.Book;

import java.util.List;

public class ApplicationShare extends Application {
    private static final String DATABASE_NAME = "library";
    private BookDb bookDb;
    private List<Book> books;

    @Override
    public void onCreate() {
        super.onCreate();
        SQLiteDatabase db = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        bookDb = new BookDb(db);
        books = bookDb.selectAll();
    }

    public BookDb getBookDb() {
        return bookDb;
    }

    public List<Book> getBooks() {
        books.clear();
        books.addAll(bookDb.selectAll());
        return books;
    }
}
