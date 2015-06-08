package ru.maven.spitter.DAO.interfaceDAO;

import java.util.List;
import ru.maven.spitter.DAO.entity.Role;
import ru.maven.spitter.DAO.entity.User;
import ru.maven.spitter.DAO.entity.Users;

public interface UserDAO {

    public void saveUser(Users user);
    
    public void saveUser(User user);
    
    public void saveRole(Role role);
    
    public void insertUser(User user);
    
    public boolean volInsertUser(User user);

    public List<Users> findAllUser();

    public List<Users> findUser(Users user);

    public void deleteUser(Users user);

    public boolean paramEquals(Users user);
}
