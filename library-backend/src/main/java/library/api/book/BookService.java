package library.api.book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class BookService {

    private BookRepository bookRepository;

    List<BookDTO> findAllNotArchived() {
        List<Book> books = bookRepository.findAllByArchivedIs(false);
        List<BookDTO> bookDTOs = new ArrayList<>();
        books.forEach(book -> bookDTOs.add(new BookDTO(book)));
        return bookDTOs;
    }

    List<BookDTO> findAllNotArchivedAndNotOccupied() {
        List<Book> books = bookRepository.findAllByArchivedIsAndOccupiedIs(false, false);
        List<BookDTO> bookDTOs = new ArrayList<>();
        books.forEach(book -> bookDTOs.add(new BookDTO(book)));
        return bookDTOs;
    }

    Book findById(long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Book not found"));
        return book;
    }

    BookDTO setBookArchived(long id) {
        Book book = findById(id);
        book.setArchived(true);
        book = bookRepository.save(book);
        return new BookDTO(book);
    }

    BookDTO setBookOccupied(long id) {
        Book book = findById(id);
        book.setOccupied(true);
        book = bookRepository.save(book);
        return new BookDTO(book);
    }
}
