package com.yang.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author yang
 * @date 2020/11/14
 */
@Data
@ToString
@EqualsAndHashCode
@Builder
public class User {
    private Integer id;
    private String name;
    private String password;

    public static void main(String[] args) {
        User user = User.builder().id(1).build();
        System.out.println(user);
    }
}

