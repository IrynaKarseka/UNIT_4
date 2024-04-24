package seminars.fourth.book;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
Задание 1. Ответьте письменно на вопросы:

1) Почему использование тестовых заглушек может быть полезным при написании модульных тестов?
            Тестовые заглушки - это любой объект, который выглядит и ведет себя, как его рабочий аналог, но
            в действительности представляет собой упрощенную версию, более удобную для тестирования. Упрощает
            обнаружение и устранение ошибок. Позволяет улучшить покрытие тестами и выявить больше потенциальных ошибок.


2) Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с определенными
аргументами?
            Mock (Имитация) заменяет реальный компонент, от которого зависит тестируемая система. Позволяет тесту
            проверять вывод.


3) Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение или исключение
в ответ на вызов метода?
            Stub (Заглушки) представляет собой объект, заменяющий реальный компонент, от которого зависит тестируемая
            система, для которого задается готовый ответ на вызов.


4) Какой тип тестовой заглушки вы бы использовали для имитации взаимодействия с внешним API или базой данных?
            Fake (Подделка) заменяет функциональность вызываемого компонента альтернативной реализацией

 */
public class BookServiceTest {

    @Test
    public void testFindBookById() {
        BookRepository mokRepository = mock(BookRepository.class);
        when((mokRepository.findById("0"))).thenReturn(new Book("0", "Book0","Author0"));
        BookService bookService = new BookService(mokRepository);
        Book resultBook = bookService.findBookById("0");
        assertEquals("0", resultBook.getId());
    }

    @Test
    public void testfindAllBooks() {
        BookRepository mockRepository = mock(BookRepository.class);
        when((mockRepository.findAll())).thenReturn(List.of(new Book("0","Book0","Author0")));
        BookService bookService = new BookService(mockRepository);
        List<Book> resultListBook = bookService.findAllBooks();
        assertEquals("0", resultListBook.get(0).getId());
    }
}
