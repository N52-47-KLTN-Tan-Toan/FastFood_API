package dev.fastfoodapi.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String name;

    private String avatar;

    private String email;

    private String phone;

    private String address;

    private String username;

    private String password;

    private String roleName;

    private Boolean gender;

    private LocalDate birthDate;

}
