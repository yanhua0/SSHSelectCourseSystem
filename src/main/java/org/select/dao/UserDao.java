package org.select.dao;

import org.select.entity.User;

public interface UserDao {
    User findByUsernameAndPassword(User user);
}
