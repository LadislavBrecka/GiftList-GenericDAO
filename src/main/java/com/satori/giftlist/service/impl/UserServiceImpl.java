package com.satori.giftlist.service.impl;

import com.satori.giftlist.domain.Gift;
import com.satori.giftlist.domain.User;
import com.satori.giftlist.repository.DaoImpl.UserDaoImpl;
import com.satori.giftlist.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public List<User> getAll() {
        return userDaoImpl.getAll();
    }

    @Override
    public User getById(Integer id) {
        try{
            return userDaoImpl.getById(id);
        }catch(Exception e){
            throw new NullPointerException("User with id: " + id + " not found");
        }
    }

    @Override
    public void create(User user) {
        userDaoImpl.create(user);
    }

    @Override
    public void delete(Integer id) {
        userDaoImpl.delete(id);
    }

    @Override
    public void update(Integer id, User user) {
        User u = userDaoImpl.getById(id);
        if(u != null) {
            user.setId(id);
            userDaoImpl.update(user);
        }else
            throw new NullPointerException("User with id: " + id + " not found");
    }
}
