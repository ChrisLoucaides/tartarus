package com.chrisloucaides.tartarus.repository;

import com.chrisloucaides.tartarus.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUserId(String userId);
    User findByUserEmail(String email);
}
