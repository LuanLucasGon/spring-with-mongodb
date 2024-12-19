package com.lucasluan.springMongo.resources;

import com.lucasluan.springMongo.domain.Post;
import com.lucasluan.springMongo.domain.User;
import com.lucasluan.springMongo.dto.UserDTO;
import com.lucasluan.springMongo.services.PostService;
import com.lucasluan.springMongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

}
