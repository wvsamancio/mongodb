package io.github.wvsamancio.mongodb.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.github.wvsamancio.mongodb.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
