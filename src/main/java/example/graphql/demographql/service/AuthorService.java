package example.graphql.demographql.service;

import example.graphql.demographql.model.Author;
import example.graphql.demographql.repo.AuthorRepository;
import example.graphql.demographql.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author getAuthor(Book blogPost) {
        return authorRepository.findById(blogPost.getId())
                .orElseThrow(EntityNotFoundException::new);
    }
}
