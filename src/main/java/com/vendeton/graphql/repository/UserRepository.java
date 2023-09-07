package com.vendeton.graphql.repository;

import com.vendeton.graphql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

}
