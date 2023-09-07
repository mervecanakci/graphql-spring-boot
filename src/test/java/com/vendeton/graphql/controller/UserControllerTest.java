package com.vendeton.graphql.controller;

import com.vendeton.graphql.model.Role;
import com.vendeton.graphql.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@AutoConfigureGraphQlTester
class UserControllerTest {
    @Autowired
    GraphQlTester graphQlTester;

    @BeforeEach
    void setUp() { // testlerden önce çalışır ve veritabanına kullanıcı ekler test için
        createUser(new User("merve", "merve@gmail.com", Role.ADMIN));
        createUser(new User("ahmet", "ahmet@gmail.com", Role.USER));
        createUser(new User("mehmet", "mehmet@gmail.com", Role.USER));
    }

    @Test
    void when_getAllUsers_should_return_userList() { // kullanıcı listesi döndürür
        // language=graphql
        String query =
                """
                        query {
                          getAllUsers{
                            id
                            username
                            role
                            created
                            updated
                          }
                        }
                        """;

        graphQlTester.document(query).execute().path("getAllUsers").entityList(User.class).hasSize(3); // 3 tane kullanıcı ekledik
    }

    @Test
    void when_createUser_should_createNewUserAndReturnUser() { // yeni kullanıcı ekler ve eklenen kullanıcıyı döndürür
        // language=graphql
        String mutation =
                """
                        mutation {
                          createUser(userRequest: {username: "feride", email: "feride@gmail.com", role: USER}) {
                            id
                            username
                            email
                            role
                            created
                            updated
                          }
                        }
                        """;
        graphQlTester
                .document(mutation)
                .execute()
                .path("createUser")
                .entity(User.class)
                .satisfies(
                        x -> {
                            assertEquals("feride", x.getUsername());
                            assertEquals("feride@gmail.com", x.getEmail());
                        });
    }

    void createUser(User user) {
        String mutation =
                """
                        mutation {
                          createUser(userRequest: {username: "%s", email: "%s", role: %s}) { 
                            id
                            username
                            role
                            created
                            updated
                          }
                        }
                        """
                        .formatted(user.getUsername(), user.getEmail(), user.getRole());

        graphQlTester.document(mutation).execute().path("createUser");
    }
    // %s: string, %d: integer, %f: float, %b: boolean, %c: char
}

