package com.yang.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;

/**
 * @author yang
 * @className UserTest2
 * @description TODO
 * @date 2020/11/14 15:11
 * @Version 1.0
 */
@Data
@ToString
@EqualsAndHashCode
public class UserTest2 {
    private String userName;
    private String password;
    /**
     *
     *@author yang
     *@description //TODO 
     *@date 18:29 2020/11/15
     *@param a
     *@return void
     */
    public static  void as(String a){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.stream().forEach(e-> System.out.println(e));




    }


}
