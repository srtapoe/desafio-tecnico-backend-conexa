package br.com.api.security;

import br.com.api.repository.MedicoRepository;
import br.com.api.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final MedicoRepository medicoRepository;
    private final TokenService tokenService;

    public SecurityFilter(JwtUtil jwtUtil, MedicoRepository medicoRepository, TokenService tokenService) {
        this.jwtUtil = jwtUtil;
        this.medicoRepository = medicoRepository;
        this.tokenService = tokenService;
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);

        if (token != null) {
            if (tokenService.ehTokenRevogado(token)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Token foi revogado. Faça login novamente.");
                return;
            }

            var email = jwtUtil.validateToken(token);
            if (email != null) {
                var userOptional = medicoRepository.findByEmail(email);
                if (userOptional.isPresent()) {
                    var user = userOptional.get();
                    var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(request, response);
    }

}
