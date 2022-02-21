package dev.fastfoodapi.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_id", updatable = false, nullable = false, unique = true, columnDefinition = "BINARY(16)")
    private UUID userId;

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
