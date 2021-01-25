package com.satori.giftlist.service.api;

import com.satori.giftlist.domain.Gift;

import java.util.List;

public interface GiftService {

    public List<Gift> getAll();

    public Gift getById(Integer id);

    public void create(Gift gift);

    public void delete(Integer id);

    public void update(Integer id, Gift gift);
}
