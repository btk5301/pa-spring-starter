package com.galvanize.tmo.paspringstarter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    @ResponseStatus(value = HttpStatus.CREATED)
    public Book addNewBook(@RequestBody Book book) {
        book.setId(idNum);
        idNum += 1;
        books.add(book);
        return book;
    }

    @GetMapping()
    public Map<String, List<Book>> getAllBooks() {
        Collections.sort(books, (o1, o2) -> o1.getTitle().toLowerCase().compareTo(o2.getTitle().toLowerCase()));
        HashMap<String, List<Book>> map = new HashMap<>();
        map.put("books", books);
        return map;
    }

    @DeleteMapping()
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAllBooks() {
        books.clear();
    }


}
