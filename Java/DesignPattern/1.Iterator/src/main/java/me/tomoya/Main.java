package me.tomoya;

import me.tomoya.object.Book;
import me.tomoya.object.BookShelf;

import java.util.Iterator;

/**
 * Created by usr0200379 on 2014/05/26.
 */
public class Main {

    public static void main(String[] args) {

        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("数学"));
        bookShelf.appendBook(new Book("国語"));
        bookShelf.appendBook(new Book("英語"));
        bookShelf.appendBook(new Book("理科"));
        Iterator it = bookShelf.iterator();

        while (it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println(book.getName());
        }
    }
}
