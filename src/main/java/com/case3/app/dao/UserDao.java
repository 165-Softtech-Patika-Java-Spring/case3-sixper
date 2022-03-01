package com.case3.app.dao;

import com.case3.app.dto.UserDto.UserResponseDto;
import com.case3.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByUserName(String name);
    User findByUserNameAndEmail(String userName, String email);

}
