package example.graphql.demographql.service;

import example.graphql.demographql.model.Author;
import example.graphql.demographql.repo.AuthorRepository;
import example.graphql.demographql.model.Book;
import example.graphql.demographql.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> allBlogPosts() {
        return new ArrayList<>(bookRepository.findAll());
    }

    public Book bookById(Long id) {
        return bookRepository.getOne(id);
    }

    @Transactional
    public Book createBook(String name, Integer pageCount, Author author) {
        Book book = new Book();
        book.setName(name);
        book.setPageCount(pageCount);
        book.setAuthor(author);
        return bookRepository.save(book);
    }
}
