package com.satori.giftlist.service.impl;

import com.satori.giftlist.domain.Gift;
import com.satori.giftlist.repository.DaoImpl.GiftDaoImpl;
import com.satori.giftlist.service.api.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftServiceImpl implements GiftService {

    @Autowired
    private GiftDaoImpl giftDaoImpl;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public List<Gift> getAll() {
        return giftDaoImpl.getAll();
    }

    @Override
    public Gift getById(Integer id) {
        try {
            return giftDaoImpl.getById(id);
        }catch (Exception e) {
            throw new NullPointerException("Gift with id: " + id + " not found");
        }
    }

    @Override
    public void create(Gift gift) {
        giftDaoImpl.create(gift);
    }

    @Override
    public void delete(Integer id) {
        giftDaoImpl.delete(id);
    }

    @Override
    public void update(Integer id, Gift gift) {
        Gift g = giftDaoImpl.getById(id);
        if(g != null) {
            gift.setId(id);
            giftDaoImpl.update(gift);
        }else
            throw new NullPointerException("Gift with id: " + id + " not found");
    }
}
