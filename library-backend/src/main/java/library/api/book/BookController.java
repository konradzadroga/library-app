package library.api.book;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET, path = "/all/notarchived")
    public ResponseEntity<List<BookDTO>> findAllNotArchived() {
        List<BookDTO> books = bookService.findAllNotArchived();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all/notarchivedandnotoccupied")
    public ResponseEntity<List<BookDTO>> findAllNotArchivedAndNotOccupied() {
        List<BookDTO> books = bookService.findAllNotArchivedAndNotOccupied();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/archived/{id}")
    public ResponseEntity<BookDTO> setBookArchived(@PathVariable long id) {
        BookDTO book = bookService.setBookArchived(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/occupied/{id}")
    public ResponseEntity<BookDTO> setBookOccupied(@PathVariable long id) {
        BookDTO book = bookService.setBookOccupied(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
