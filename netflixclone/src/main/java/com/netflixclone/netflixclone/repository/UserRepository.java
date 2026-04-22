package com.netflixclone.netflixclone.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.netflixclone.netflixclone.entity.user;
import java.util.Optional;  

public interface UserRepository extends JpaRepository<user, Long> { // JpaRepository provides basic CRUD operations for the user entity, and we can also define custom query methods here
    Optional<user> findByEmail(String email);

    
} 