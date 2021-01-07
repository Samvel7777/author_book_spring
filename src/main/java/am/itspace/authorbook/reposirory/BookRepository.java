package am.itspace.authorbook.reposirory;

import am.itspace.authorbook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
