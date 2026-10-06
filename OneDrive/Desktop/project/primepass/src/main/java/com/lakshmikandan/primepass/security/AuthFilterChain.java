package com.lakshmikandan.primepass.security;

import com.lakshmikandan.primepass.model.UsersModel;
import com.lakshmikandan.primepass.repository.UsersRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Service
public class AuthFilterChain extends OncePerRequestFilter {
    @Autowired
    public JwtUtil jwtUtil;
    @Autowired
    public UsersRepository usersRepo;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String header = request.getHeader("Authorization");
    if (header !=null && header.startsWith("Bearer ")) {
        String token = header.substring(7);
        if(jwtUtil.tokenValidation(token)){
       String email = jwtUtil.unWrap(token);
            Optional<UsersModel> user = usersRepo.findByEmail(email);
            if(user.isPresent()){
                UsersModel usersM = user.get();
                UsernamePasswordAuthenticationToken userF = new UsernamePasswordAuthenticationToken(usersM,null, Collections.singleton(new SimpleGrantedAuthority("ROLE_"+usersM.getRole())));
                SecurityContextHolder.getContext().setAuthentication(userF);
            }
        }
    }
    filterChain.doFilter(request,response);

    }
}
