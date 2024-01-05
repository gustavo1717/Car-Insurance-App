package com.synex.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synex.domain.User;
import com.synex.service.UserService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

@Controller
public class WelcomeController {

	@Autowired UserService userService;
	/*@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String home() {
		
		return "Home";
		
	}*/
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String home(Principal principal, Model model) {
		Authentication authentication = (Authentication) principal;

        if (authentication != null) {
            // Check if the principal is an instance of UserDetails
            if (authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails) {
                org.springframework.security.core.userdetails.UserDetails userDetails =
                    (org.springframework.security.core.userdetails.UserDetails) authentication.getPrincipal();

                // Get the authorities (roles) from UserDetails
                Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

                // Now you can use the authorities (roles) as needed
                for (GrantedAuthority authority : authorities) {
                    String role = authority.getAuthority();
                    // Add the roles to the model or perform any other actions
                    model.addAttribute("role", role);
                }
            }
        }
        
		model.addAttribute("userIsAuthenticated", false);
		if (principal != null) {
			
			
			model.addAttribute("userIsAuthenticated", true);
	        model.addAttribute("principalName", principal.getName());
	        
	        System.out.println(principal.getName());
	        String username = principal.getName();
	        User user = userService.findByUserName(username);
	        //model.addAttribute("userEmail", user.getEmail());
	    }
		
		return "Home";
		
	}
	
	@GetMapping("/register")
		public String register() {
		return "signup";
	}
	
	@GetMapping("/claim")
	public String claim(Principal principal, Model model) {
		model.addAttribute("principalName", principal.getName());
		User user = userService.findByUserName(principal.getName());
		model.addAttribute("policyId", user.getPolicyId());
		return "claim";
	}
	
	@RequestMapping(value = "/insuranceForm",method = RequestMethod.GET)
	public String insuranceForm(Principal principal, Model model) {
		model.addAttribute("principalName", principal.getName());
		
		return "InsuranceForm";
	}
	
	
	@RequestMapping(value = "/admin",method = RequestMethod.GET)
	public String admin() {
		
		return "admin";
		
	}
	
	@RequestMapping(value = "/profile",method = RequestMethod.GET)
	public String profile(Principal principal, Model model) {
		
		model.addAttribute("principalName", principal.getName());
		
		return "Profile";
		
	}
	
	@GetMapping("/plans")
	public String plans(Principal principal, Model model) {
		//String principalName = principal != null ? principal.getName() : null;
	    //	model.addAttribute("principalName", principalName);
		//System.out.println(principal.toString());
		if (principal != null) {
			model.addAttribute("principalName", principal.getName());
	        
		}
		
		return "Plans";
	}
	
}
