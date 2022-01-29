package com.yang.service.impl;

import com.yang.dao.UserDAO;
import com.yang.entity.User;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
//@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

    /**
     *
     *@Author yang
     *@Description //TODO
     *@Date 15:07 2020/11/14
     *@Param []
     *@return java.util.List<com.yang.entity.User>
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> select() {
        System.out.println("dsafsadfsad");
        return userDAO.select();
    }
}
