package com.galvanize.tmo.paspringstarter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/books")
public class LibraryController {

    private List<Book> books = new ArrayList<>();
    public int idNum = 1;

    @GetMapping("/health")
    public String health() {
        return "Hello world";
    }

    @PostMapping()
    public Book addNewBook(@RequestBody Book book) {
        book.setId(idNum);
        idNum += 1;
        books.add(book);
        return book;
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        Collections.sort(books, (o1, o2) -> o1.getTitle().toLowerCase().compareTo(o2.getTitle().toLowerCase()));
        return books;
    }

    @DeleteMapping()
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAllBooks() {
        books.clear();
    }


}
