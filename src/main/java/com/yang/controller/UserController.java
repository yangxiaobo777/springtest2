package com.yang.controller;

import com.yang.entity.User;
import com.yang.service.UserService;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author yang
 * @date 2020/11/14
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<User> selectAll(){
        ArrayList<String> strings = new ArrayList<String>();
        strings.stream().forEach(e->{
            System.out.println(e);
        });

        return userService.select();

    }
    @RequestMapping("/a")
    public String a(){
        HashMap<String, String> map = new HashMap<>();

        return "asdfsdfsadfsdafsadfdsfa";
    }
    @RequestMapping("/upload")
    public String upload(MultipartFile aaa, HttpServletRequest request)throws Exception{
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
//        System.out.println(realPath);
//        System.out.println(aaa.getName());
//        System.out.println(aaa.getContentType());
//        System.out.println(aaa.getOriginalFilename());
        String a=aaa.getOriginalFilename();

        //System.out.println(a);
        aaa.transferTo(new File(realPath,a));
        return "index";
    }

    @RequestMapping("/download")
    public void download(String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = request.getRealPath("/upload");
        FileInputStream fileInputStream=new FileInputStream(new File(realPath,name));
        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(name,"UTF-8"));
        IOUtils.copy(fileInputStream,outputStream);
        IOUtils.closeQuietly(fileInputStream);
        IOUtils.closeQuietly(outputStream);
    }

    @RequestMapping("/aa")
    @ResponseBody
    public String aa(){
        Logger logger = Logger.getLogger(getClass());
        logger.debug("safdsfasfd");
        String aaa = "jjjj";
        aaa.matches("");
//        Logger logger = LoggerFactory.getLogger(getClass());
//        logger.info("fasdf");
        return "index";
    }
}
