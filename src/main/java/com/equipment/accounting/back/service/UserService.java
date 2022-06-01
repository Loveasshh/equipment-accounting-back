package com.equipment.accounting.back.service;

import com.equipment.accounting.back.model.User;

public interface UserService {
    User getByUserId (Long id);
    User getByUserUsername (String username);
    Boolean existUserById (Long id);

    Boolean existUserByName (String username);
}
