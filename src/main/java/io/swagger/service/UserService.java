package io.swagger.service;

import io.swagger.model.User;
import io.swagger.models.auth.In;
import io.swagger.repository.UserRepository;
import io.swagger.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    private UserRepository UserRepository;

    @Override
    public Response getAllUsers() {
        try {
            List<User> list = UserRepository.findAll();
            return new Response("Retrieve the list", HttpStatus.OK, list);
        } catch (Exception exception){
            return new Response("The list of users have some inconsistent.", HttpStatus.CONFLICT);
        }
    }

    @Override
    public Response updateUserById(Integer id, User user) {
        Response response = getUserById(id);
        if(response.getUser()!= null) {
            User oldUser = response.getUser();
            oldUser.setAddress(user.getAddress());
            oldUser.setEmail(user.getEmail());
            oldUser.setName(user.getName());
            oldUser.setBirthDate(user.getBirthDate());
            UserRepository.save(user);
            return new Response("The user has been updated!", HttpStatus.OK, user);
        }
        else {
            return new Response("The user not exists!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Response saveUser(User user) {
        Response userExists = getUserById(user.getId());
        if (userExists.getUser() == null) {
            this.UserRepository.save(user);
            return new Response("The user has been created!", HttpStatus.CREATED, user);
        }else{
            return new Response("The user exists!", HttpStatus.CONFLICT);
        }
    }

    @Override
    public Response getUserById(Integer id) {
        Optional<User> optionalUser = UserRepository.findById(id);
        User user;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
            return new Response("The user exists!", HttpStatus.OK, user);
        } else {
            //throw new RuntimeException("User not found for id : " + id);
            return new Response("The user not exists!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Response deleteUserById(Integer id) {
        Response user = getUserById(id);
        if (user.getUser()!= null) {
            this.UserRepository.deleteById(id);
            return new Response("The user has been deleted!", HttpStatus.OK);
        }else{
            return new Response("The user not exists!", HttpStatus.NOT_FOUND);
        }
    }

}
