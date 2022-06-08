package com.equipment.accounting.back.controller;

import com.equipment.accounting.back.config.jwt.JwtUtils;
import com.equipment.accounting.back.model.Role;
import com.equipment.accounting.back.model.RoleEnum;
import com.equipment.accounting.back.model.User;
import com.equipment.accounting.back.response.JwtRs;
import com.equipment.accounting.back.request.LoginRq;
import com.equipment.accounting.back.response.MessageRs;
import com.equipment.accounting.back.request.SignupRq;
import com.equipment.accounting.back.repository.RoleRepository;
import com.equipment.accounting.back.repository.UserRepository;
import com.equipment.accounting.back.service.impl.UserDetailsImpl;
import com.equipment.accounting.back.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRespository;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authUser(@RequestBody LoginRq loginRq) {
        boolean isEmployee = true;

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRq.getUsername(),
                        loginRq.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        if (userService.existUserById(userDetails.getId())) {
            isEmployee = userService.getByUserId(userDetails.getId()).getIsEmployee();
        }
        int i = 1;
        return ResponseEntity.ok(new JwtRs(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles, isEmployee));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRq signupRq) {

        if (userRespository.existsByUsername(signupRq.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageRs("Error: Username is exist"));
        }

        User user = new User(signupRq.getUsername(),
                passwordEncoder.encode(signupRq.getPassword()));

        Set<String> reqRoles = signupRq.getRoles();

        Set<Role> roles = new HashSet<>();

        if (reqRoles == null) {
            Role userRole = roleRepository
                    .findByName(RoleEnum.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error, Role USER is not found"));
            roles.add(userRole);
        } else {
            reqRoles.forEach(r -> {
                switch (r) {
                    case "admin":
                        Role adminRole = roleRepository
                                .findByName(RoleEnum.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error, Role ADMIN is not found"));
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleRepository
                                .findByName(RoleEnum.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error, Role USER is not found"));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRespository.save(user);
        return ResponseEntity.ok(new MessageRs("User CREATED"));
    }
}