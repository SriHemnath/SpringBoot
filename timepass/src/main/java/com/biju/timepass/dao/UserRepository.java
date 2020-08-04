package com.biju.timepass.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biju.timepass.entity.UserProfile;

public interface UserRepository extends JpaRepository<UserProfile, Integer> {

}
