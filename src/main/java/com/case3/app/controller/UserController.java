package com.case3.app.controller;


import com.case3.app.dto.UserDto.UserResponseDto;
import com.case3.app.dto.UserDto.UserSaveDto;
import com.case3.app.dto.UserDto.UserUpdateDto;
import com.case3.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity save(@RequestBody UserSaveDto userSaveDto){

        UserResponseDto userResponseDto = userService.save(userSaveDto);

        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping
    public ResponseEntity findAll(){

        List<UserResponseDto> userResponseDtoList = userService.findAll();

        return ResponseEntity.ok(userResponseDtoList);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Long id){

        UserResponseDto userResponseDto = userService.getByIdWithControl(id);

        return ResponseEntity.ok(userResponseDto);
    }

    @PatchMapping
    public ResponseEntity update(@RequestBody UserUpdateDto userUpdateDto){

        UserResponseDto userResponseDto = userService.update(userUpdateDto);

        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping("/findByUserName")
    public ResponseEntity findByName(@RequestParam(value = "userName") String userName){

        UserResponseDto userResponseDto = userService.findByUserName(userName);

        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity delete(@RequestParam String userName, @RequestParam String email){

        userService.delete(userName, email);

        return ResponseEntity.ok(Void.TYPE);
    }

}
