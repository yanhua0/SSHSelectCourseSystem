package org.select.service;

import org.select.entity.User;
import org.springframework.transaction.annotation.Transactional;


public interface UserService {
    User login(User user);
}
