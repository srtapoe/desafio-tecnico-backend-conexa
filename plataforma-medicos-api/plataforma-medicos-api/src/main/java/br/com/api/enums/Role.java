package br.com.api.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN("Admin"), USER("User");

    private final String name;

    @Override
    public String getAuthority() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    Role(String name) {
        this.name = name;
    }
}
