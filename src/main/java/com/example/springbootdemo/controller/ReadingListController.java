package com.example.springbootdemo.controller;

import com.example.springbootdemo.jpadao.ReadingListRepository;
import com.example.springbootdemo.model.Book;
import com.example.springbootdemo.serivce.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController("/book")
@Api(value = "Book apis")
@RequestMapping("/book")
public class ReadingListController {

    //    @Autowired
    private ReadingListRepository readingListRepository;

    //    @Autowired
    private BookService bookService;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository, BookService bookService) {
        this.readingListRepository = readingListRepository;
        this.bookService = bookService;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    @ApiOperation(value = "Query books by reader", httpMethod = "GET")
    public String readersBooks(@PathVariable String reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    @ApiOperation(value = "save book", httpMethod = "POST")
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/book/{reader}";
    }

    @RequestMapping("/queryPageable")
    @ApiOperation(value = "Query books by page", httpMethod = "GET")
    @ResponseBody
    public List<Book> queryPageable(@RequestParam(value = "page", defaultValue = "0") int curPage, @RequestParam(value = "size", defaultValue = "2") int size, String reader) {
        List<Book> books = bookService.queryPageable(curPage, size, reader);

        return books;
    }


//    @RequestMapping("/readingList")
//    public String readingList(Model model) {
//        List<Book> readingList = readingListRepository.findByReader(reader);
//        if (readingList != null) {
//            model.addAttribute("books", readingList);
//        }
//        return "readingList";
//    }
}
