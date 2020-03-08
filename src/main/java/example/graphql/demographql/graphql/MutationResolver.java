package example.graphql.demographql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import example.graphql.demographql.graphql.input.CreateAuthorInput;
import example.graphql.demographql.graphql.input.CreateBookInput;
import example.graphql.demographql.model.Author;
import example.graphql.demographql.model.Book;
import example.graphql.demographql.repo.AuthorRepository;
import example.graphql.demographql.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class MutationResolver implements GraphQLMutationResolver {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public Author createAuthor(CreateAuthorInput input) {
        Author author = new Author();
        author.setFirstName(input.getFirstName());
        author.setLastName(input.getLastName());
        return authorRepository.saveAndFlush(author);
    }

    @Transactional
    public Book createBook(CreateBookInput input) {
        Book book = new Book();
        book.setAuthor(authorRepository.getOne(Long.valueOf(input.getAuthorId())));
        book.setPageCount(input.getPageCount());
        book.setName(input.getName());
        return bookRepository.saveAndFlush(book);
    }
}
