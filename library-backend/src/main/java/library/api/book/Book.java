package library.api.book;
import library.api.order.Order;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Size(max = 4)
    private int year;

    @NotBlank
    private String author;

    @NotBlank
    private boolean occupied;

    @NotBlank
    private boolean archived;

    @OneToMany(mappedBy = "book")
    private List<Order> orders;

    public Book(@NotBlank String name, @NotBlank String description, @Size(max = 4) int year, @NotBlank String author) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.author = author;
        this.occupied = false;
        this.archived = false;
    }
}
