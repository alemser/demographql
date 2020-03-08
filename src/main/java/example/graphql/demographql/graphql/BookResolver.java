package example.graphql.demographql.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import example.graphql.demographql.model.Author;
import example.graphql.demographql.model.Book;
import example.graphql.demographql.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class BookResolver implements GraphQLResolver<Book> {
    @Autowired
    private AuthorRepository authorRepository;

    public Author getAuthor(Book book) {
        Author author = authorRepository.findById(book.getAuthor().getId()).orElseThrow(EntityNotFoundException::new);
        return author;
    }
}
