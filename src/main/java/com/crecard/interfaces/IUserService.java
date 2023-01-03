package com.crecard.interfaces;

import com.crecard.model.User;


public interface IUserService {
    public  String signIn(User user);
    public String signOut(User user);
    public User changePassword(User user,String np);
	//User changePassword(long id, User user);


}
