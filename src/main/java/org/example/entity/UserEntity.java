package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String tranaction;

    public UserEntity(String name, String transaction) {
        this.name = name;
        this.tranaction = transaction;
    }
}