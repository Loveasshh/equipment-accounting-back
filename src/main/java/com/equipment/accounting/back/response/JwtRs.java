package com.equipment.accounting.back.response;

import java.util.List;

public class JwtRs {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private List<String> roles;

    private boolean isEmployee;

    public JwtRs(String token, Long id, String username, List<String> roles, boolean isEmployee) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.isEmployee = isEmployee;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(boolean employee) {
        isEmployee = employee;
    }
}