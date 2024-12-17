package com.lucasluan.springMongo.resources;

import com.lucasluan.springMongo.domain.User;
import com.lucasluan.springMongo.dto.UserDTO;
import com.lucasluan.springMongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> userList = userService.findAll();
        List<UserDTO> listDto = userList.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(listDto);
    }
}
