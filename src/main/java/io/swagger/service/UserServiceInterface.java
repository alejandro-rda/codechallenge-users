package io.swagger.service;

import io.swagger.model.User;
import io.swagger.models.auth.In;
import io.swagger.utils.Response;

import java.util.List;

public interface UserServiceInterface {

        Response getAllUsers();
        Response updateUserById(Integer id, User User);
        Response saveUser(User user);
        Response getUserById(Integer id);
        Response deleteUserById(Integer id);

}
