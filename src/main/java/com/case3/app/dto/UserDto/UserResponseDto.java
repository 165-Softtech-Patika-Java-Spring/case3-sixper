package com.case3.app.dto.UserDto;

import com.case3.app.enums.UserType;
import lombok.Data;



@Data
public class UserResponseDto {

    private Long id;
    private String userName;
    private String email;
    private String phoneNumber;
    private UserType userType;

}
