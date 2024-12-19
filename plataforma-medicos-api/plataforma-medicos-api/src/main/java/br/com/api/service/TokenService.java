package br.com.api.service;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class TokenService {

    private final Set<String> revokedTokens = new HashSet<>();

    private final CacheManager cacheManager;

    public TokenService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @CachePut(value = "tokensRevogados", key = "#token")
    public void revogarToken(String token) {
        Cache cache = cacheManager.getCache("tokensRevogados");
        if (cache == null) {
            throw new IllegalStateException("Cache 'tokensRevogados' não encontrado!");
        }
        cache.put(token, true);
    }

    @Cacheable(value = "tokensRevogados", key = "#token")
    public boolean ehTokenRevogado(String token) {
        Cache cache = cacheManager.getCache("tokensRevogados");
        if (cache == null) {
            throw new IllegalStateException("Cache 'tokensRevogados' não encontrado!");
        }
        Boolean tokenRevogado = cache.get(token, Boolean.class);
        return tokenRevogado != null && tokenRevogado;
    }
}
