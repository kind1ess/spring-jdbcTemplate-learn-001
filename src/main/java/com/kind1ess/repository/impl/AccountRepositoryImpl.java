package com.kind1ess.repository.impl;

import com.kind1ess.model.Account;
import com.kind1ess.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("accountRepository")
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Account> findAll() {
        return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }

    public Account findById(Integer id) {
        List<Account> accounts = jdbcTemplate.query("select 8 from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),id);
        return accounts.isEmpty()? null:accounts.get(0);
    }

    public List<Account> findByName(String name) {
        return jdbcTemplate.query("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),name);
    }

    public void insertAccount(Account account) {
        jdbcTemplate.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }

    public void deleteById(Integer id) {
        jdbcTemplate.update("delete account where id=?",id);
    }
}
