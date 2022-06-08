package com.equipment.accounting.back.service;

import com.equipment.accounting.back.model.User;
import org.springframework.data.repository.query.Param;

public interface UserService {
    User getByUserId (Long id);
    User getByUserUsername (String username);
    Boolean existUserById (Long id);

    void deleteByUserName (String username);

    Boolean existUserByName (String username);

    int setIsEmployeeForUser (boolean isEmployee, String username );
}
