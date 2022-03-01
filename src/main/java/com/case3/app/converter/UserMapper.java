package com.case3.app.converter;

import com.case3.app.dto.UserDto.UserResponseDto;
import com.case3.app.dto.UserDto.UserSaveDto;
import com.case3.app.dto.UserDto.UserUpdateDto;
import com.case3.app.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User convertToUser(UserSaveDto userSaveDto);

    User convertToUser(UserUpdateDto userUpdateDto);

    UserResponseDto convertToUserResponseDto(User user);

    List<UserResponseDto> convertToUserResponseDtoList(List<User> userList);
}
