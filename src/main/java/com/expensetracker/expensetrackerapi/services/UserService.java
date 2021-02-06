package com.expensetracker.expensetrackerapi.services;

import com.expensetracker.expensetrackerapi.domain.User;
import com.expensetracker.expensetrackerapi.exceptions.EtAuthException;

public interface UserService
{
    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstname, String lastname, String email, String password) 
                                    throws EtAuthException;
    
}