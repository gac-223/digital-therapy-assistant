package com.digitaltherapyassistant.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.apache.catalina.authenticator.BasicAuthenticator.BasicCredentials;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.digitaltherapyassistant.dto.request.auth.LoginRequest;
import com.digitaltherapyassistant.dto.request.auth.RegisterRequest;
import com.digitaltherapyassistant.dto.response.auth.AuthResponse;
import com.digitaltherapyassistant.entity.User;
import com.digitaltherapyassistant.repository.UserRepository;
import com.digitaltherapyassistant.security.JwtTokenProvider;
import com.digitaltherapyassistant.security.TokenBlackListService;
import com.digitaltherapyassistant.service.AuthServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AuthServiceImplTest {
    @Mock private UserRepository userRepository;
    @Mock private JwtTokenProvider tokenProvider;
    @Mock private PasswordEncoder passwordEncoder;
    @Mock private AuthenticationManager authenticationManager;
    @Mock private TokenBlackListService tokenBlackListService;

    @InjectMocks private AuthServiceImpl authServiceImpl;

    @Test
    public void registerTest(){

        //200 OK
        RegisterRequest request = new RegisterRequest();
        request.setEmail("user@chapman.edu");
        request.setName("User");
        request.setPassword("password");

        when(userRepository.findByEmail("user@chapman.edu"))
        .thenReturn(Optional.empty());

        when(passwordEncoder.encode("password"))
        .thenReturn("encodedPassword");

        when(tokenProvider.generateAccessToken(any()))
        .thenReturn("accessToken");
        when(tokenProvider.generateRefreshToken(any()))
        .thenReturn("refreshToken");
        

        AuthResponse response = authServiceImpl.register(request);
        assertEquals("accessToken", response.getAccessToken());
        assertEquals("refreshToken", response.getRefreshToken());
        assertEquals("Registered", response.getMessage());

        //400 BAD REQUEST
        when(userRepository.findByEmail("user@chapman.edu"))
        .thenReturn(Optional.of(new User()));

        response = authServiceImpl.register(request);
 
        assertEquals("User Already Exists", response.getMessage());
        assertNull(response.getAccessToken());
        assertNull(response.getRefreshToken());
        assertNull(response.getUserID());
    }

    @Test
    public void testLogin(){
        LoginRequest request = new LoginRequest();
        request.setEmail("user@chapman.edu");
        request.setPassword("password");

        // doThrow(BasicCredentials.class)
        // .when(authenticationManager.authenticate(any()));

        //AuthResponse response = authServiceImpl.login(request);
    }
}