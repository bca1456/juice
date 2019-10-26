package com.example.juice;

import com.example.juice.domain.User;
import com.example.juice.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class GreetingController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<User> users = userRepository.findAll();  // получаем список всех пользователей
        model.put("users", users); //добавляем в модель
        return "main";
    }

    @PostMapping
    public String addNewUser(@RequestParam String name, Map<String, Object> model){
        User user = new User(name);
        System.out.println("/////////////////////////////////////////////////////////////////////");
        userRepository.save(user); //сохраняем пользователя

        Iterable<User> users = userRepository.findAll(); //опять чекнули все из репы
        model.put("users", users); //положили обновленную репу в модель

        return "main";
    }

    @PostMapping("idFilter")
    public String idFilter(@RequestParam Integer userID, Map<String, Object> model){
        Optional<User> users = userRepository.findById(userID);
        Iterable<User> q = Arrays.asList(new User("dadaya", 666));
        model.put("users", q);
        return "main";
    }
}
