package com.example.springbootdemo.serivce;

import com.example.springbootdemo.model.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> queryPageable(int curPage, int size, String reader);
}
