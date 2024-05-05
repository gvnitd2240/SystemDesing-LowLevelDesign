package org.example.SplitWise.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserController {
    List<User> userList;

    public UserController(){
        userList = new ArrayList<>();
    }

    public User add(String userId, String userName){
        User user = new User(userId, userName);
        userList.add(user);
        return user;
    }

    public User getUser(String userID) throws Exception {
        List<User>  users = userList.stream().filter(it -> it.userId == userID).toList();
        if (users.size() == 0) {throw new Exception("NO such user");}
        return users.get(0);
    }

    public List<User> getAllUsers(){
        return userList;
    }

}
