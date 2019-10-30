package com.example.juice.controller;

import com.example.juice.domain.Role;
import com.example.juice.domain.User;
import com.example.juice.repos.UserRepository;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
//    @Autowired
//    private UserRepository userRepository;
//
//    @GetMapping("/registration") //просто возвращаем вью
//    public String registration(){
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String addUser(User user, Map<String, Object> model){
//        User userFromDb = userRepository.findByUsername(user.getUsername());
//
//        if (userFromDb != null){
//            model.put("books", "User exists!");
//            return "registration";
//        }
//
//        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.USER));
//        userRepository.save(user);
//        return "redirect:/login"; //при успешной регистрации редирект на страницу логина
//    }
}
