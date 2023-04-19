package com.tecnotree.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tecnotree.training.entity.Author;
import com.tecnotree.training.entity.Book;
import com.tecnotree.training.repository.BookRepository;

@Controller
@RequestMapping(path="/book")
public class BookController {
  
  @Autowired
  private BookRepository bookRepository;

  @PostMapping(path="/add")
  public @ResponseBody String addNewBook (@RequestParam String title, @RequestParam String publisher,
      @RequestParam int price, @RequestParam String isbn, @RequestParam String description,
      @RequestParam long author_id) {

    Book book = new Book();
    book.setTitle(title);
    book.setPublisher(publisher);
    book.setPrice(price);
    book.setIsbn(isbn);
    book.setDescription(description);
    Author author = new Author();
    author.setId(author_id);
    book.setAuthor(author);

    bookRepository.save(book);
    return "Saved";
  }

  @GetMapping(path="/all")
  public ModelAndView getAllBook() {
      ModelAndView mav = new ModelAndView("Books");
      mav.addObject("Books", bookRepository.findAll());
      return mav;
  }
}
