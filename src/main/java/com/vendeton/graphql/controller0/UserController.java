package com.vendeton.graphql.controller0;

import com.vendeton.graphql.model.User;
import com.vendeton.graphql.model.UserRequest;
import com.vendeton.graphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @QueryMapping //getmapping gibi burada da querymapping kullanılır
    List<User> getAllUsers() { //ResponseEntity ile döndürülebilir ama sıkıntı çıkarabiliyor schema.graphqls dosyasında değişiklik yaparsan yazadabilirsin
        return userService.getAllUsers();
    }
    @QueryMapping // @QueryMapping: graphql query kullarak veri çekme işlemi yapar ayrıca @Argument ile parametre alabilir
    User getUserById(@Argument Long id) { // @Argument: graphql query ile gelen parametreleri alır. (@Argument Long id: schema.graphqls dosyasında id parametresi ile çağırılır, yanlış yazmamaya dikkat et
        return userService.getUserById(id); // userService sınıfındaki getUserById metodunun çağırır
    }
    @MutationMapping // @MutationMapping: graphql mutation kullarak veri ekleme, güncelleme ve silme işlemleri yapar
    User createUser(@Argument UserRequest userRequest) {
        return userService.createUser(userRequest); // userService sınıfındaki createUser metodunun çağırır
    }

    @MutationMapping
    User updateUser(@Argument UserRequest userRequest) {
        return userService.updateUser(userRequest);
    }

    @MutationMapping
    Boolean deleteUser(@Argument Long id) {
        userService.deleteUser(id);
        return true; // true döndürürse silme işlemi başarılıdır
    }
}
