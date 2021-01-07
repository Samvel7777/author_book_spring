package am.itspace.authorbook.service;

import am.itspace.authorbook.model.Book;
import am.itspace.authorbook.reposirory.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }

    public Book getBook(int id) {
        return bookRepository.getOne(id);
    }
}
