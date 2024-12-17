package com.lucasluan.springMongo.dto;

import com.lucasluan.springMongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO(User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }

}
