package com.lakshmikandan.primepass.service;

import com.lakshmikandan.primepass.model.UsersModel;
import com.lakshmikandan.primepass.repository.UsersRepository;
import com.lakshmikandan.primepass.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    public UsersRepository usersRepository;
    @Autowired
    public JwtUtil jwtUtil;
    @Autowired
    public BCryptPasswordEncoder encoder;
    public ResponseEntity<?> register(Map<String, String> user) {
        String userName = user.get("username");
        String password = user.get("password");
        String email = user.get("email");
        long phoneFNo ;
        try {
            phoneFNo= Long.parseLong(user.get("phoneNo"));
        }
        catch (NumberFormatException nfException){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(nfException);
        }
        if (usersRepository.findByEmail(email).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already Existed");
        }
        UsersModel userC =UsersModel.builder().email(email).userName(userName).password(encoder.encode(password)).phoneNo(phoneFNo).build();
        usersRepository.save(userC);
        return ResponseEntity.status(HttpStatus.CREATED).body("Succsess fully Registered");
    }

    public ResponseEntity<?> login(Map<String, String> user) {
        String password = user.get("password");
        String email = user.get("email");
        Optional<UsersModel> userO = usersRepository.findByEmail(email);
        if (userO.isPresent()){
            UsersModel userf =userO.get();
            if (encoder.matches(password,userf.getPassword())){
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(Map.of("Token",jwtUtil.tokenGenerator(email)));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
    }
}
