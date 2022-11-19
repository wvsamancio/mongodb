package io.github.wvsamancio.mongodb.controller;

import org.slf4j.LoggerFactory;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.wvsamancio.mongodb.dal.UserRepository;
import io.github.wvsamancio.mongodb.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping
    public List<User> getAllUsers() {
        LOG.info("Getting all users");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        LOG.info("Getting user with ID: {}.", id);
            Query query = new Query();
            query.addCriteria(Criteria.where("id").is(id));
            return mongoTemplate.findOne(query, User.class);
    }

    @PostMapping
    public User createNewUser(@RequestBody User user) {
        LOG.info("Create new user");
        return repository.save(user);
    }
    
}
