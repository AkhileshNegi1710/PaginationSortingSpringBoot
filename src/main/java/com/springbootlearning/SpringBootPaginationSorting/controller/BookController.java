package com.springbootlearning.SpringBootPaginationSorting.controller;


import com.springbootlearning.SpringBootPaginationSorting.entity.BookEntity;
import com.springbootlearning.SpringBootPaginationSorting.exception.NotResourceFoundException;
import com.springbootlearning.SpringBootPaginationSorting.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class BookController {
    @Autowired
    BookRepository bookRepository;



//    Get all the books
    @GetMapping
    public Page<BookEntity> getAllBooks(@RequestParam Optional<String> sortBy, @RequestParam Optional<Integer> page)
    {


//        if SortBy not present then it will automatically sort by id

//        inside findALl() will take page request not parameters

//        if page has nothing it will print 0 and total size is 4

//       Use Request Param sortBy as localhost:8888/library?sortBy=bookname

//       Use & to add next param localhost:8888/library?sortBy=bookname&page=2

        return bookRepository.findAll(
                PageRequest.of(
                page.orElse(0),
                        4,
                Sort.Direction.DESC,sortBy.orElse("id")));

    }


//    add new Book in Library
    @PostMapping("/newBook")
    public BookEntity addBook(@RequestBody BookEntity bookEntity)

    {
        return bookRepository.save(bookEntity);

    }

    @DeleteMapping("/{bookid}")
    public ResponseEntity<HttpStatus> deletebookById(@PathVariable long bookid)
{
   BookEntity bookEntity=bookRepository.findById(bookid).orElseThrow(()->new NotResourceFoundException("Not found Id: "+bookid));
       bookRepository.delete(bookEntity);
       return new ResponseEntity(HttpStatus.NO_CONTENT);

}



}
