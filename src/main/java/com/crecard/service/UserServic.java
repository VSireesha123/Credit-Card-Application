package com.crecard.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crecard.execption.UserException;
import com.crecard.interfaces.IUserService;
import com.crecard.model.User;
import com.crecard.repository.UserRepository;
@Service("userservice")
public class UserServic implements IUserService {
	/**
	* injecting the UserRepository into repository reference using autowired
	* annotation
	*/
	@Autowired
	UserRepository userrepository;
	/**
	* logic to signin
	*/
	public String signIn(User user)throws UserException {
	// TODO Auto-generated method stub
	String name=user.getUserId();
	String password=user.getPassword();
	User u=findById(name);
	if(u != null) {
	if(u.getPassword().equals(password)) {
	u.setActive(true);
	userrepository.save(u);
	return "user is authenticated";
	}
	else {
	return "user is not authenticated";
	}
	}
	else {
	throw new UserException("invalid credentials");
	}
	}
	/**
	* logic to signout
	*/
	public String signOut(User user)throws UserException {
	// TODO Auto-generated method stub
	String name=user.getUserId();
	String password=user.getPassword();
	User u=findById(name);
	if(u !=null) {
	if(u.getPassword().equals(password)) {
	u.setActive(false);
	userrepository.save(u);
	return "signout successfully";
	}
	else {
	return "incorrect password";
	}
	}
	else {
	throw new UserException("invalid credintials");
	}
	}
	public User findById(String name) {
	Optional<User> op=userrepository.findById(name);
	if(op.isPresent()) {
	return op.get();
	}
	else {
	return null;
	}
	 
	}
	/**
	* logic to change password
	*/
	public User changePassword(User user,String password)
	{
	String password1=user.getPassword();
	String new_password;
	List<User> users=userrepository.findAll();
	for(User user1:users)
	{
	if(Objects.equals(user1.getUserId(), user.getUserId())&& Objects.equals(user1.getPassword(),user.getPassword()))
	{
	user1.setPassword(password);
	new_password=user1.getPassword();
	userrepository.save(user1);
	return user1;
	}
	}
	return user;
	}
	/*@Override
	public User changePassword(long id, User user) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	

}
