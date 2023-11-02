package seminarFour;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import seminar.four.homework.Book;
import seminar.four.homework.BookRepository;
import seminar.four.homework.BookService;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// Подключение расширения Mockito к тестируемому классу
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    /* 1. Создаем mock -заглушку для интерфейса BookRepository
    * */
    @Mock
    private BookRepository mockBockRepository;

    /* 2. Внедряем  заглушку в конструктор класса BookService
    * */
    @InjectMocks
    private BookService bookService;

    /**
     * Тестируем поведение метода findBookById класса BookService
     */
    @Test
    public void findBookByIdShouldReturnBook() {

        when(mockBockRepository.findById("1")).thenReturn(new Book("1", "SomeTitle", "SomeAuthor"));

        /* 3. Создаем ожидаемый id и получаем id книги при вызове метода findBookById() класса BookService.
        * */
        String expectIdBook = "1";
        String actualIdBook = bookService.findBookById("1").getId();

        /* 4. Проверяем что у заглушки один раз был вызван метод findById() с аргументом 1
        * */

        verify(mockBockRepository).findById("1");

        /* 5. Проверяем что ожидаемый id равен id полученного объекта
        * */

        assertEquals(expectIdBook, actualIdBook, "Метод findBookById возвращает объект с некорректным ID");
    }

    /**
     * Проверяем поведение метода findAllBooks класса BookService
     */
    @Test
    public void findAllBooksShouldReturnListBooks() {

        when(mockBockRepository.findAll())
                .thenReturn(new ArrayList<>(Arrays.asList(
                        new Book("1"),
                        new Book("2"),
                        new Book("3"),
                        new Book("4")
                )));

        /* 6. Задаем ожидаемый размер листа книг и получаем размер листа при вызове метода findAllBooks класса BookService
        * */

        int expectedSizeListBooks = 4;
        int actualSizeListBooks = bookService.findAllBooks().size();

        /* 7. Проверяем что у заглушки один раз был вызван метод findAll()
        * */

        verify(mockBockRepository).findAll();

        /* 8. Проверяем что размер листа равен полученному
        * */

        assertEquals(expectedSizeListBooks,
                actualSizeListBooks,
                "Метод findAllBooks возвращает некорректный размер листа с книгами");
    }


}
