package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.SongRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Song;
import com.example.demo.model.User;
import com.example.demo.service.SecurityService;
import com.example.demo.service.UserService;
import com.example.demo.web.UserValidator;

@Controller
public class UserController {

	@Autowired
	public UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private UserValidator userValidator;
    
    
    @GetMapping("/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        model.addAttribute("userForm", new User());
        
        model.addAttribute("roles", roleRepo.findAll());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }
    
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model, @ModelAttribute("userForm") User userForm) {
    	model.addAttribute("loggedinuser", getPrincipal());
        return "welcome";
    }
    
    @GetMapping({"/userList"})
    public String viewUserList(Model model) {
    	model.addAttribute("users", userRepo.findAll());
        return "userList";
    }
    
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
    
    
    //

//	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
//	public String loginPage() {
//		return "login";
//	}

//	private boolean isCurrentAuthenticationAnonymous() {
//	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	    return authenticationTrustResolver.isAnonymous(authentication);
//	}

}
