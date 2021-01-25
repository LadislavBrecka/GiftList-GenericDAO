package com.satori.giftlist.repository.DaoApi;

import java.util.List;

public interface BaseDao<T>{
    public void create(T obj);
    public void update(T obj);
    public void delete(Integer id);
    public T getById(Integer id);
    public List<T> getAll();
}
