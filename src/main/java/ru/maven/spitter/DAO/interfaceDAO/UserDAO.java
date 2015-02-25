package ru.maven.spitter.DAO.interfaceDAO;

import java.sql.SQLException;
import java.util.List;
import ru.maven.spitter.DAO.entity.Users;

public interface UserDAO {
    
    public void saveUser(String s[]) throws SQLException;
    
    public List<Users> findAllUser();
    
//    public void findUser();
    
//    public void deleteUser(Integer id);
    
    public void edit(String myParam[]);
}
