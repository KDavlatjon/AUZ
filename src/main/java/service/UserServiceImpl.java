package service;

import model.Result;
import model.User;

import java.util.List;

public interface UserServiceImpl {
    Result search(String name, String password, List<User> userList);
    List<User> read();
}
