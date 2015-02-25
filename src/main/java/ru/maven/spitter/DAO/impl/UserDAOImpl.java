package ru.maven.spitter.DAO.impl;


import java.sql.SQLException;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.maven.spitter.DAO.entity.Users;
import ru.maven.spitter.DAO.interfaceDAO.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    public UserDAOImpl() {
    }
    
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    @Transactional
    public void saveUser(String myParam[]) throws SQLException{
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
    
}
