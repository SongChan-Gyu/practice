package com.example.testing.upbit.Service;

import com.example.testing.upbit.Domain.model.Account;
import com.example.testing.upbit.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpbitTestService {

    @Autowired
    private AccountRepository accountRepository;

    public void saveAccounts(List<Account> lst){
        accountRepository.saveAll(lst);
    }

    public List<Account> selectAll(){
        return accountRepository.findAll();
    }
}
