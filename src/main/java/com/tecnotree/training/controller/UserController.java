package com.tecnotree.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tecnotree.training.entity.User;
import com.tecnotree.training.repository.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UserRepository userRepository;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String firstname,@RequestParam String lastname
      , @RequestParam String email,@RequestParam String password) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    User n = new User();
    n.setFirstName(firstname);
    n.setLastName(lastname);
    n.setEmail(email);
    n.setPassword(password);
    userRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public ModelAndView getAllUsers() {
      ModelAndView mav = new ModelAndView("Users");
      System.out.println( userRepository.findAll());
      mav.addObject("Users", userRepository.findAll());
      return mav;
  }
}