package am.itspace.authorbook.reposirory;

import am.itspace.authorbook.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
