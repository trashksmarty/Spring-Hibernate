package ru.maven.spitter.DAO.interfaceDAO;

import java.util.List;
import ru.maven.spitter.DAO.entity.Users;

public interface UserDAO {

    public void saveUser(Users user);

    public List<Users> findAllUser();

    public List<Users> findUser(Users user);

    public void deleteUser(Users user);

    public boolean paramEquals(Users user);
}
