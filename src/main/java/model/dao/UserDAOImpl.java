package main.java.model.dao;

import entity.UsersEntity;
import main.java.model.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private BCryptPasswordEncoder encoder;

    @Autowired
    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public void insertUser(String login, String password, String name, String surname) throws Exception {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        UsersEntity userEntity = new UsersEntity();

        String encode = encoder.encode(password);

        userEntity.setLogin(login);
        userEntity.setPassword(encode);
        userEntity.setRole("ROLE_USER");
        userEntity.setName(name);
        userEntity.setSurname(surname);
        userEntity.setIdRoom(0);

        session.save(userEntity);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public List<UsersEntity> selectAllUsers() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        List<UsersEntity> users = null;
        try{
            tx = session.beginTransaction();
            users = session.createCriteria(UsersEntity.class).list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return users;
    }

    @Override
    public UsersEntity selectUserByLogin(String login) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        UsersEntity user = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("from UsersEntity where login = :paramName");
            query.setParameter("paramName", login);
            List list = query.list();
            user = (UsersEntity) list.get(0);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return user;
    }
}
