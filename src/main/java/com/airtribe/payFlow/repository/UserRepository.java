package com.airtribe.payFlow.repository;

import com.airtribe.payFlow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUpiId(String upiId);

    @Query("SELECT u FROM User u WHERE u.balance > :amount")
    List<User> findUsersWithBalanceGreaterThan(@Param("amount") Double amount);
}
