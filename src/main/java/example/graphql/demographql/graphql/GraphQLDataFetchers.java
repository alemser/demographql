package example.graphql.demographql.graphql;

import example.graphql.demographql.model.Book;
import example.graphql.demographql.repo.AuthorRepository;
import example.graphql.demographql.repo.BookRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GraphQLDataFetchers {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public DataFetcher getAllBooks() {
        return dataFetchingEnvironment -> {
            return bookRepository.findAll();
        };
    }

    public DataFetcher getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return bookRepository.getOne(Long.valueOf(bookId));
        };
    }

    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            return book.getAuthor();
        };
    }

    public DataFetcher getPageCountDataFetcher() {
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            return book.getPageCount();
        };
    }
}
