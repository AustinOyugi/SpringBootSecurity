package com.task001.clif.controller;

import com.task001.clif.model.User;
import com.task001.clif.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.NoSuchElementException;
import java.util.Optional;

@Configuration
@EnableWebMvc
@RestController
public class CheckUserIfExists extends WebMvcConfigurerAdapter
{
    @Autowired
    private UsersRepository usersRepository;

    @CrossOrigin
    @RequestMapping(value = "/addUser/{email}", method = RequestMethod.GET)
    public String mtuAko(@PathVariable String email)
    {
        String newEmail = email+".com";
        Optional<User> user = Optional.ofNullable(usersRepository.findByEmail(newEmail)).orElse(null);
        if(!user.isPresent())
        {
            return "Hakuna";
        }

        return "Available";
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/addUser/**");
    }
}
