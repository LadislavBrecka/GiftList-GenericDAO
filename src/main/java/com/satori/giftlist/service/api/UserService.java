package com.satori.giftlist.service.api;

import com.satori.giftlist.domain.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();

    public User getById(Integer id);

    public void create(User user);

    public void delete(Integer id);

    public void update(Integer id, User user);
}
