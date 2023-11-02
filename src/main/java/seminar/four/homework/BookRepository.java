package seminar.four.homework;

import java.util.List;

public interface BookRepository {

    Book findById(String id);
    List<Book> findAll();
}
