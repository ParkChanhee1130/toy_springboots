package com.study.toy_springboots.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping({"/", ""})
    public ModelAndView main(ModelAndView mv){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            String password = ((UserDetails) principal).getPassword();

            System.out.println("Username : " + username);
            System.out.println("Password : " + password);
            System.out.println(((UserDetails) principal).getAuthorities());
            System.out.println(((UserDetails) principal).isAccountNonExpired());
            System.out.println(((UserDetails) principal).isCredentialsNonExpired());
            System.out.println(((UserDetails) principal).isEnabled());
        } else {
            String username = principal.toString();
        }
        mv.setViewName("home/home");
        return mv; 
    }
}
