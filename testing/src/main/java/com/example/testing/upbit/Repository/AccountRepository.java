package com.example.testing.upbit.Repository;

import com.example.testing.upbit.Domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    
}
