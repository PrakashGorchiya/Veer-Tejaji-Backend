package demo.service;

import demo.dto.LoginRequest;
import demo.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    Boolean validateToken(String token);
}
