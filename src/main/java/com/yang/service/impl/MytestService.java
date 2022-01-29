package com.yang.service.impl;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

/***
 *
 *@author yang
 *@description //TODO
 *@date 23:20 2020/11/25
 *@param
 *@return
 */
public class MytestService implements Serializable {
      private static final Properties p=new Properties();

      static {
          try{
              InputStream resourceAsStream = MytestService.class.getResourceAsStream("/file");
              p.load(resourceAsStream);


          }catch(Exception e){

          }
      }


}
