package com.yang.springsecuritys.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author yang
 * @className CaptchaController
 * @description TODO
 * @date 2021/12/20 10:39
 * @Version 1.0
 */
@RestController
@RequestMapping("/image")
public class CaptchaController {

    @Autowired
    private Producer producer;

    @GetMapping("/captcha.jpg")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        String producerText = producer.createText();
        request.getSession().setAttribute("captcha",producerText);
        BufferedImage image = producer.createImage(producerText);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image,"jpg",outputStream);
        try{
            outputStream.flush();
        }finally {
            outputStream.close();
        }



    }
}
