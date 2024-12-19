package com.lucasluan.springMongo.services;

import com.lucasluan.springMongo.domain.Post;
import com.lucasluan.springMongo.domain.User;
import com.lucasluan.springMongo.dto.UserDTO;
import com.lucasluan.springMongo.repositories.PostRepository;
import com.lucasluan.springMongo.repositories.UserRepository;
import com.lucasluan.springMongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }

}
