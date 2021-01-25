package com.satori.giftlist.repository.DaoImpl;

import com.satori.giftlist.domain.Gift;
import com.satori.giftlist.repository.DaoApi.BaseDao;
import com.satori.giftlist.repository.DaoApi.GiftDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GiftDaoImpl extends BaseDaoImpl<Gift> implements GiftDao {

    public GiftDaoImpl() {
        setClazz(Gift.class);
    }
}
