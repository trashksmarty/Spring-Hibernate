package ru.maven.spitter.flow;

import org.springframework.stereotype.Component;
import ru.maven.spitter.DAO.entity.Users;

@Component
public class AddUsersFlow {

    public Users createUser(String name){
        Users user = new Users();
        user.setNickName(name);
        return user;
    }
}
