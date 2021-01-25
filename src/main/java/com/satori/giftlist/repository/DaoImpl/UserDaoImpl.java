package com.satori.giftlist.repository.DaoImpl;

import com.satori.giftlist.domain.User;
import com.satori.giftlist.repository.DaoApi.BaseDao;
import com.satori.giftlist.repository.DaoApi.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        setClazz(User.class);
    }
}
