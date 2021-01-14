package library.api.book;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BookDTO {

    private long id;
    private String name;
    private String description;
    private int year;
    private String author;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.description = book.getDescription();
        this.year = book.getYear();
        this.author = book.getAuthor();
    }
}
