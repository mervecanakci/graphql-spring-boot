package com.vendeton.graphql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "'users'")
public class User extends  BaseEntity{

    private String username;
    private String email;
    @Enumerated(EnumType.STRING)// EnumType.STRING: Enum değerlerinin veritabanında String olarak saklanmasını sağlar.
    private Role role;

}
