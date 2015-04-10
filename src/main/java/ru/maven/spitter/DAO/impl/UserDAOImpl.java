package ru.maven.spitter.DAO.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.maven.spitter.DAO.entity.Users;
import ru.maven.spitter.DAO.interfaceDAO.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public UserDAOImpl() {
    }

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void saveUser(String myParam[]) throws SQLException {
        Users user = new Users();
        user.setNickName(myParam[0]);
        user.setFirstName(myParam[1]);
        user.setLastName(myParam[2]);
        user.setEmail(myParam[3]);
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    @Transactional
    public List<Users> findAllUser() {
        List<Users> resoult = sessionFactory.getCurrentSession().createCriteria(Users.class).list();
        return resoult;
    }

    @Override
    @Transactional
    public void edit(String myParam[]) {
        Users user = new Users();
        user.setId(Integer.parseInt(myParam[0]));
        user.setNickName(myParam[1]);
        user.setFirstName(myParam[2]);
        user.setLastName(myParam[3]);
        user.setEmail(myParam[4]);
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        Users user = new Users();
        user.setId(id);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    @Transactional
    public List<Users> findUser(String myParam[]) {
        List<Users> l = new ArrayList<Users>();

        Users user = new Users();

        Criteria crt = sessionFactory.getCurrentSession()
                .createCriteria(Users.class);

        // Nick, First Name, Last Name, Email.
        if (!myParam[1].equals("")) {
            user.setNickName(myParam[1]);
            crt.add(Restrictions.like("nickName", "%" + myParam[1] + "%").ignoreCase());
        } else {
            user.setNickName(null);
        }
        if (!myParam[2].equals("")) {
            user.setFirstName(myParam[2]);
            crt.add(Restrictions.like("firstName", "%" + myParam[2] + "%").ignoreCase());
        } else {
            user.setFirstName(null);
        }
        if (!myParam[3].equals("")) {
            user.setLastName(myParam[3]);
            crt.add(Restrictions.like("lastName", "%" + myParam[3] + "%").ignoreCase());
        } else {
            user.setLastName(null);
        }
        if (!myParam[4].equals("")) {
            user.setEmail(myParam[4]);
            crt.add(Restrictions.like("email", "%" + myParam[4] + "%").ignoreCase());
        } else {
            user.setEmail(null);
        }

        // ID
        if (!myParam[0].equals("")) {
            l = sessionFactory.getCurrentSession().createQuery("from Users where id=?")
                    .setParameter(0, Integer.parseInt(myParam[0])).list();
        } else {
        // OTHER
            l = crt.list();
        }
        return l;
    }

    @Override
    public boolean paramEquals(String[] s) {
        if (!s[0].equals("")) {
            return true;
        } else if (!s[1].equals("")) {
            return true;
        } else if (!s[2].equals("")) {
            return true;
        } else if (!s[3].equals("")) {
            return true;
        } else if (!s[4].equals("")) {
            return true;
        }
        return false;
    }

}
