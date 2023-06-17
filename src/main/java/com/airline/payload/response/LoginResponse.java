package com.airline.payload.response;
import com.airline.dto.userDto.response.UserDtoResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String message;
    private UserDtoResponse userDtoResponse;
    private String token;

    public LoginResponse(String message,String token) {
        this.message = message;
        this.token = token;
    }

    public LoginResponse(String message,UserDtoResponse userDtoResponse, String token) {
        this.message = message;
        this.userDtoResponse = userDtoResponse;
        this.token = token;
    }

    public LoginResponse() {
    }
}

