package com.equipment.accounting.back.repository;

import com.equipment.accounting.back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    User getByUsername(String username);

    @Modifying
    @Query("update User u set u.isEmployee = :isEmployee where u.username = :username")
    int setIsEmployeeForUser(@Param("isEmployee") boolean isEmployee, @Param("username") String username);
}