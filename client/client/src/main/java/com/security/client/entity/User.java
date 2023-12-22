package com.security.client.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;


    private String email;

    @Column(length = 60)
    private String  password;

    private String role;

    private boolean enabled = false;
}
