package library.api.order;

import library.api.book.Book;
import library.api.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private Date orderDate;

    @NotBlank
    private Date orderDueDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    public Order(@NotBlank Date orderDate, @NotBlank Date orderDueDate, User user, Book book) {
        this.orderDate = orderDate;
        this.orderDueDate = orderDueDate;
        this.user = user;
        this.book = book;
    }
}
