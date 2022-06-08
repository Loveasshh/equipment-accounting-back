package com.equipment.accounting.back.service.impl;

import com.equipment.accounting.back.model.User;
import com.equipment.accounting.back.repository.UserRepository;
import com.equipment.accounting.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getByUserUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public User getByUserId(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public Boolean existUserById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public Boolean existUserByName(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void deleteByUserName(String username) {
        userRepository.findByUsername(username).get().setIsEmployee(false);
    }

    @Override
    public int setIsEmployeeForUser(boolean isEmployee, String username) {
        return userRepository.setIsEmployeeForUser(isEmployee,username);
    }
}
