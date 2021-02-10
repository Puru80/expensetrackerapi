package com.expensetracker.expensetrackerapi.services;

import java.util.regex.Pattern;

import com.expensetracker.expensetrackerapi.domain.User;
import com.expensetracker.expensetrackerapi.exceptions.EtAuthException;
import com.expensetracker.expensetrackerapi.repositories.UserRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService 
{
    @Autowired
    UserRepositories userRepo;

    @Override
    public User validateUser(String email, String password) throws EtAuthException 
    {
        if(email!=null) email = email.toLowerCase();
        return userRepo.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) 
            throws EtAuthException 
    {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email!=null)
            email = email.toLowerCase();
        if(!pattern.matcher(email).matches())
            throw new EtAuthException("Invalid Email Format");
        Integer count = userRepo.getCountByEmail(email);
        if(count>0)
            throw new EtAuthException("Email already in use");
        Integer userId = userRepo.create(firstName, lastName, email, password);
        return userRepo.findById(userId);
    }
        
}
