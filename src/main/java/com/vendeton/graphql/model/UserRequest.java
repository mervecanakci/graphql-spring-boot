package com.vendeton.graphql.model;

import lombok.Data;

@Data
public class UserRequest {
    private Long id;
    private String username;
    private String email;
    private Role role;
}
