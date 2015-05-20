package ru.maven.spitter.DAO.impl;

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
    public List<Users> findAllUser() {
        List<Users> resoult = sessionFactory.getCurrentSession().createCriteria(Users.class).list();
        return resoult;
    }

    @Override
    @Transactional
    public void saveUser(Users user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void deleteUser(Users user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    @Transactional
    public List<Users> findUser(Users user) {
        List<Users> l = new ArrayList<Users>();

        Criteria crt = sessionFactory.getCurrentSession()
                .createCriteria(Users.class);

        // ID
        if (user.getId() != null) {
            l = sessionFactory.getCurrentSession().createQuery("from Users where id=?")
                    .setParameter(0, user.getId()).list();
        } else {

            // Nick, First Name, Last Name, Email.
            if (!user.getNickName().isEmpty()) {
                crt.add(Restrictions.like("nickName", "%" + user.getNickName() + "%").ignoreCase());
            }
            if (!user.getFirstName().isEmpty()) {
                crt.add(Restrictions.like("firstName", "%" + user.getFirstName() + "%").ignoreCase());
            }
            if (!user.getLastName().isEmpty()) {
                crt.add(Restrictions.like("lastName", "%" + user.getLastName() + "%").ignoreCase());
            }
            if (!user.getEmail().isEmpty()) {
                crt.add(Restrictions.like("email", "%" + user.getEmail() + "%").ignoreCase());
            }
            l = crt.list();
        }
        return l;
    }

    @Override
    public boolean paramEquals(Users user) {
        if (user.getId() != null) {
            return true;
        } else if (!user.getNickName().isEmpty()) {
            return true;
        } else if (!user.getFirstName().isEmpty()) {
            return true;
        } else if (!user.getLastName().isEmpty()) {
            return true;
        } else if (!user.getEmail().isEmpty()) {
            return true;
        }
        return false;
    }
}
