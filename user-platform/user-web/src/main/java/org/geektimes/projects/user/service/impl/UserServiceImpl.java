package org.geektimes.projects.user.service.impl;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.sql.DBConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private static  DatabaseUserRepository  databaseUserRepository;
    private static UserServiceImpl userService;
    static {
        String databaseURL = "jdbc:derby:/db/user-platform;create=true";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(databaseURL);
            DBConnectionManager dbConnectionManager = new DBConnectionManager();
            dbConnectionManager.setConnection(connection);
            databaseUserRepository =  new DatabaseUserRepository(dbConnectionManager);
            userService = new UserServiceImpl();
        } catch (SQLException e) {
        }
    }

   public static UserServiceImpl getInstance(){
        return userService;
   }

    @Override
    public boolean register(User user) {
        return databaseUserRepository.save(user);
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }
}
