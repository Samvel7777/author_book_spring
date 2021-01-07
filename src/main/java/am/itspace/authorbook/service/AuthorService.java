package am.itspace.authorbook.service;

import am.itspace.authorbook.model.Author;
import am.itspace.authorbook.reposirory.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public void deleteAuthorById(int id) {
        authorRepository.deleteById(id);
    }

    public Author getAuthor(int id) {
        return authorRepository.getOne(id);
    }
}
