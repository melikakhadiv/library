package ir.mft.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity(name = "bookEntity")
@Table(name = "book_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "b_id")
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String publisher;

    private boolean available = true;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User borrowedBy;



}
