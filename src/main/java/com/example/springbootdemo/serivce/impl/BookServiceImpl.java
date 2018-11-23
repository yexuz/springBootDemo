package com.example.springbootdemo.serivce.impl;

import com.example.springbootdemo.jpadao.ReadingListRepository;
import com.example.springbootdemo.model.Book;
import com.example.springbootdemo.serivce.BookService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private ReadingListRepository readingListRepository;

    @Override
    public Book save(Book book) {
        return readingListRepository.save(book);
    }

    @Override
    public List<Book> queryPageable(int curPage, int size, String reader) {
//        PageHelper.startPage(curPage,size).setOrderBy("id desc"); 此处无用
        List<Book> byReader = readingListRepository.findByReader(reader);
        return  byReader;
    }
}
