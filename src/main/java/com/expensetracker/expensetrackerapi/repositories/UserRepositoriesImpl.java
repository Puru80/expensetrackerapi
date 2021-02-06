package com.expensetracker.expensetrackerapi.repositories;

import com.expensetracker.expensetrackerapi.domain.User;
import com.expensetracker.expensetrackerapi.exceptions.EtAuthException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoriesImpl implements UserRepositories 
{
    private static final String SQL_CREATE = "INSERT INTO ET_USERS(USER_ID, FIRST_NAME, LAST_NAME, "+
    "EMAIL, PASSWORD) VALUES (NEXTVAL('ET_USERS_SEQ'), ?, ?, ?, ?)";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(String firstName, String lastName, String email, String password) throws EtAuthException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            // jdbcTemplate
        } catch (Exception e) {
            throw new EtAuthException("Invalid Details");
        }
        return null;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws EtAuthException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer getCountByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findById(Integer userId) {
        // TODO Auto-generated method stub
        return null;
    }
        
}
