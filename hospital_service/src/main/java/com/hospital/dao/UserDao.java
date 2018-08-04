package com.hospital.dao;

import com.hospital.entity.User;

public interface UserDao {
    User selectByName(String username);
}
