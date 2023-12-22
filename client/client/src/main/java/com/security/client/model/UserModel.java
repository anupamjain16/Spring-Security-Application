package com.security.client.model;

import jakarta.persistence.Column;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserModel {


    private long id;

    private String name;


    private String email;

    @Column(length = 60)
    private String  password;

    private String role;

    private boolean enabled = false;
}
