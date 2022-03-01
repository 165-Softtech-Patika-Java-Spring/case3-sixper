package com.case3.app.service;

import com.case3.app.converter.UserMapper;
import com.case3.app.dto.UserDto.UserResponseDto;
import com.case3.app.dto.UserDto.UserSaveDto;
import com.case3.app.dto.UserDto.UserUpdateDto;
import com.case3.app.entity.User;
import com.case3.app.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityService userEntityService;

    public UserResponseDto save(UserSaveDto userSaveDto){

        User user = UserMapper.INSTANCE.convertToUser(userSaveDto);

        user = userEntityService.save(user);

        return UserMapper.INSTANCE.convertToUserResponseDto(user);
    }


    public List<UserResponseDto> findAll() {

        List<User> userList = userEntityService.findAll();

        return UserMapper.INSTANCE.convertToUserResponseDtoList(userList);
    }

    public UserResponseDto getByIdWithControl(Long id){

        User user = userEntityService.getByIdWithControl(id);

        return UserMapper.INSTANCE.convertToUserResponseDto(user);
    }

    public UserResponseDto update(UserUpdateDto userUpdateDto){

        Long id = userUpdateDto.getId();

        User user;
        if(userEntityService.existById(id)){
            user = UserMapper.INSTANCE.convertToUser(userUpdateDto);
            userEntityService.save(user);
        }else{
            throw new RuntimeException("The user ID did not match!");
        }

        return UserMapper.INSTANCE.convertToUserResponseDto(user);
    }


    public UserResponseDto findByUserName(String name) {

        User user = userEntityService.findByUserName(name);

        return UserMapper.INSTANCE.convertToUserResponseDto(user);
    }

    public void delete(String userName, String email) {

        User user = userEntityService.findByUserNameAndEmail(userName, email);

        if(user == null){
            throw new RuntimeException("Username and email did not match!");
        }else{
            userEntityService.delete(user);
        }
    }
}
