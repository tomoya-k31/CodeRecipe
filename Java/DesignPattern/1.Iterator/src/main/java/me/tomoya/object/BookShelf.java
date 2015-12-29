package me.tomoya.object;

import me.tomoya.interfaces.Aggregate;

import java.util.Iterator;

/**
 * Created by usr0200379 on 2014/05/27.
 */
public class BookShelf implements Aggregate {

    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int idx) {
        return books[idx];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
