package com.kind1ess.repository;


import com.kind1ess.model.Account;

import java.util.List;

public interface AccountRepository {

    /**
     * 查询所有
     */
    List<Account> findAll();

    /**
     * 根据id查询
     */
    Account findById(Integer id);

    /**
     * 根据姓名查询
     */

    List<Account> findByName(String name);

    /**
     * 增加账户
     */
    void insertAccount(Account account);

    /**
     * 更改账户
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     */
    void deleteById(Integer id);
}
