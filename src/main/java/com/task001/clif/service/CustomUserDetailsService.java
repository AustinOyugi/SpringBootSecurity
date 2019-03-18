package com.task001.clif.service;

import com.task001.clif.model.CustomUserDetails;
import com.task001.clif.model.User;
import com.task001.clif.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = usersRepository.findByName(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return optionalUser.map(CustomUserDetails::new).get();
    }


}
