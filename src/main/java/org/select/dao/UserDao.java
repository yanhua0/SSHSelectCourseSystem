package org.select.dao;

import org.select.entity.User;

import java.util.List;

public interface UserDao {
    User findByUsernameAndPassword(User user);
    void save(User user);
    void saveList(List<User> user);
    void deleteList(List<User> user);
    void updateList(List<User> user);
}
