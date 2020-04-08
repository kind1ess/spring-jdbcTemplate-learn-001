package com.kind1ess.jdbctemplate;

import com.kind1ess.config.Config;
import com.kind1ess.model.Account;
import com.kind1ess.repository.AccountRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class JdbcTemplateDemo1 {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        AccountRepository accountRepository = (AccountRepository) applicationContext.getBean("accountRepository");
        List<Account> accountList = accountRepository.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }
}
