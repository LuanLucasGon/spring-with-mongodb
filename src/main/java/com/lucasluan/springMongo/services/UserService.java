package com.lucasluan.springMongo.services;

import com.lucasluan.springMongo.domain.User;
import com.lucasluan.springMongo.dto.UserDTO;
import com.lucasluan.springMongo.repositories.UserRepository;
import com.lucasluan.springMongo.services.exceptions.ObjectNotFoundException;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User user){
        User newUser = findById(user.getId());
        updateData(user, newUser);
        return userRepository.save(newUser);
    }

    private void updateData(User user, User newUser) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
