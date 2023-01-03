package com.crecard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crecard.model.User;
@Repository("userrepository")
public interface UserRepository extends JpaRepository<User,String> {

}
