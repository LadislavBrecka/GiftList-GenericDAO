package com.satori.giftlist;

import com.satori.giftlist.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class GiftListApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GiftListApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

}
