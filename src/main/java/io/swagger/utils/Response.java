package io.swagger.utils;

import io.swagger.model.User;
import org.springframework.http.HttpStatus;
import java.util.List;

public class Response {

    private String message;
    private HttpStatus code;

    private User user;

    private List<User> userList;

    public Response(String message, HttpStatus code) {
        this.message = message;
        this.code = code;
    }

    public Response(String message, HttpStatus code, User user) {
        this.message = message;
        this.code = code;
        this.user = user;
    }

    public Response(String message, HttpStatus code, List<User> userList) {
        this.message = message;
        this.code = code;
        this.userList = userList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
