package com.crecard.interfaces;

import com.crecard.model.User;

public interface IUserService {
    public  User signIn(User user);
    public User signOut(User user);
    public User changePassword(long id,User user);


}
