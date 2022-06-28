package com.stackdeans.loginregister.repository;

import com.stackdeans.loginregister.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ghonim
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
//    User findByUsername1(String username1);

    boolean deleteByUsername(String username);

    Boolean existsByUsername(String username);


    Boolean existsByEmail(String email);
}
