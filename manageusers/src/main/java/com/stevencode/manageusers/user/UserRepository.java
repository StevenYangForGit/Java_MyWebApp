package com.stevencode.manageusers.user;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Long countById(Integer id);

    @Query("SELECT u FROM User u WHERE "
        + "CONCAT(u.id, ' ', u.email, ' ', u.password, ' ', u.firstName, ' ', u.lastName, ' ', u.enabled)"
        + " LIKE %?1%")
    public Page<User> findAll(Pageable pageable, String keyword);
}

