package com.hospital.service;

import com.hospital.entity.User;

public interface LoginService {
    User login(String username, String password);
}
