package ir.mft.library.controller;


import ir.mft.library.entity.Book;
import ir.mft.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/book")
@RequiredArgsConstructor
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Book> save(Book book){
        return ResponseEntity.ok(bookService.save(book));
    }

    @PutMapping
    public ResponseEntity<Book> edit(Book book){
        return ResponseEntity.ok(bookService.edit(book));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{bookId}/borrow/{userId}")
    public ResponseEntity<Book> borrow(@PathVariable Long bookId , @PathVariable Long userId){
        return ResponseEntity.ok(bookService.borrow(bookId,userId));
    }
}
