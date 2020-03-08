package example.graphql.demographql.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import example.graphql.demographql.model.Book;
import example.graphql.demographql.repo.AuthorRepository;
import example.graphql.demographql.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public Book bookById(Long id) throws ChangeSetPersister.NotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return book;
    }

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
}
