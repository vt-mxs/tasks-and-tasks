package com.etesc.tasksandtasks.api.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etesc.tasksandtasks.api.dto.request.UserLoginRequestDTO;
import com.etesc.tasksandtasks.api.dto.request.UserRequestDTO;
import com.etesc.tasksandtasks.api.dto.response.UserResponseDTO;
import com.etesc.tasksandtasks.api.exception.UserAlreadyExistsException;
import com.etesc.tasksandtasks.api.exception.UserNotFoundException;
import com.etesc.tasksandtasks.api.repository.UserRepository;
import com.etesc.tasksandtasks.model.User;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserResponseDTO loginUser(UserLoginRequestDTO dto){
        Optional<User> optionalUser = repository.findByEmail(dto.email());
        if (optionalUser.isEmpty()) throw new UserNotFoundException("Usuário não encontrado");
        
        User user = optionalUser.get();
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }

    public UserResponseDTO createUser(UserRequestDTO dto){
        Optional<User> optionalUser = repository.findByEmail(dto.email());
        if(optionalUser.isPresent()) throw new UserAlreadyExistsException("Usuário com email já cadastrado");

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());

        repository.save(user);

        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }
}