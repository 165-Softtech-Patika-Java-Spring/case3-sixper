package com.case3.app.service.entityservice;

import com.case3.app.converter.UserMapper;
import com.case3.app.dao.UserDao;
import com.case3.app.dto.UserDto.UserResponseDto;
import com.case3.app.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserEntityService {

    private final UserDao userDao;

    public User save(User user){
        return userDao.save(user);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }

    public Optional<User> findById(Long id){
        return userDao.findById(id);
    }

    public User getByIdWithControl(Long id){

        Optional<User> userOptional = userDao.findById(id);

        User user;
        if(userOptional.isPresent()){
            user = userOptional.get();
        }else{
            throw new RuntimeException("User not found!");
        }

        return user;
    }

    public Boolean existById(Long id){
        return userDao.existsById(id);
    }

    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    public void delete(User user){
        userDao.delete(user);
    }

    public User findByUserNameAndEmail(String userName, String email){
        return userDao.findByUserNameAndEmail(userName, email);
    }
}
