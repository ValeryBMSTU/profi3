package org.example.service;

public class UserData {
    private final String email;

    private String password;

    private final String name;

    private final String surname;

    private final String mobile;

    public UserData(String email,
                    String password,
                    String name,
                    String surname,
                    String mobile) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }
}
