package com.task001.clif.controller;

import com.task001.clif.model.User;
import com.task001.clif.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController
{
    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String registration(Model model)
    {
        model.addAttribute("user", new User());

        return "signup";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, Model model)
    {
        usersRepository.save(user);

        return "login";
    }
}