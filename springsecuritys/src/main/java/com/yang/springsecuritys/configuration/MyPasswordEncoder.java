package com.yang.springsecuritys.configuration;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author yang
 * @className MyPasswordEncoder
 * @description TODO
 * @date 2021/12/16 10:22
 * @Version 1.0
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(rawPassword.toString());
    }


}
