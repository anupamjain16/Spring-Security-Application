package com.security.client.repository;

import com.security.client.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRegistrionRepository extends JpaRepository<User,Long>
{

}
