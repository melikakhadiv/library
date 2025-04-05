package ir.mft.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity(name = "userEntity")
@Table(name = "user_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "u_id")
    private Long id;

    @NotBlank
    @Column(name = "u_first_name")
    private String firstName;

    @NotBlank
    @Column(name = "u_last_name")
    private String lastName;

    @NotBlank
    @Email
    @Column(name = "u_email")
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Invalid national ID")
    @Column(name = "u_national_code")
    private String nationalCode;



}
