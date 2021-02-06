package com.expensetracker.expensetrackerapi.repositories;

import com.expensetracker.expensetrackerapi.domain.User;
import com.expensetracker.expensetrackerapi.exceptions.EtAuthException;

public interface UserRepositories 
{

        Integer create(String firstName, String lastName, String email, String password) 
                                throws EtAuthException;
    
        User findByEmailAndPassword(String email, String password) throws EtAuthException;
    
        Integer getCountByEmail(String email);
    
        User findById(Integer userId);
}   
