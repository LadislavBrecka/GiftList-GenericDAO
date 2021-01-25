package com.satori.giftlist.repository.DaoImpl;


import com.satori.giftlist.repository.DaoApi.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    public void setClazz(Class<T> clazz){
        this.clazz = clazz;
    }

    public void create(T obj) {
        entityManager.persist(obj);
    }

    public void update(T obj) {
        entityManager.merge(obj);
    }

    public void delete(Integer id) {
        T entity = getById(id);
        entityManager.remove(entity);
    }

    public List<T> getAll(){
        return entityManager.createQuery("from "+clazz.getName()).getResultList();
    }

    public T getById(Integer id) {
        return entityManager.find(clazz, id);
    }
}
