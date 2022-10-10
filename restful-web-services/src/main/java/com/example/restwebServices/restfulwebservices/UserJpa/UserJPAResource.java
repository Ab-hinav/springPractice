package com.example.restwebServices.restfulwebservices.UserJpa;

import com.example.restwebServices.restfulwebservices.posts.Post;
import com.example.restwebServices.restfulwebservices.user.User;
import com.example.restwebServices.restfulwebservices.user.UserDaoService;
import com.example.restwebServices.restfulwebservices.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResource {

    private UserDaoService service;
    private userJpaRepo repo;

    public UserJPAResource(UserDaoService service , userJpaRepo repo) {
        this.service = service;
        this.repo = repo;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return repo.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = repo.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id-" + id);
        }
        EntityModel<User> resource = EntityModel.of(user.get());
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        resource.add(link.withRel("all-users"));
        return resource;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        repo.save(user);
        URI location = URI.create(String.format("/users/%s", user.getId()));
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        repo.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostForUser(@PathVariable int id) {
        Optional<User> user = repo.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id-" + id);
        }
        return user.get().getPosts();
    }



}
