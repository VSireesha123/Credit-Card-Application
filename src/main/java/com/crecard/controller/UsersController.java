package com.crecard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crecard.execption.UserException;
import com.crecard.interfaces.IUserService;
import com.crecard.model.User;

@RestController
@RequestMapping("/user")
public class UsersController {
	@Autowired
	IUserService userservice;
	/**

	* This method sends the new signin details to the add method in UserService
	*
	*
	*/
	@PostMapping("/signin")
	public String signIn(@RequestBody User user)throws UserException{
	return userservice.signIn(user);
	}
	/**
	* This method sends the new signout details to the add method in UserService
	*
	*
	*/
	@PostMapping("/signout")
	public String signOut(@RequestBody User user)throws UserException {
	return userservice.signOut(user);
	}

	/**
	* This method changes the old password to new password
	*
	*
	*/
	@PutMapping("/changepassword/{password}")
	public User changePassword(@RequestBody User user, String password)
	{
	return userservice.changePassword(user,password);
	}

}
