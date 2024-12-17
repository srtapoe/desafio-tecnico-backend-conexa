package br.com.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@AllArgsConstructor
public enum Role implements GrantedAuthority {

    ADMIN("Admin"), USER("User");

    private final String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
