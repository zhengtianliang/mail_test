package com.controller;


import com.util.SendmailUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;


/**
 * @author: ZhengTianLiang
 * @date: 2021/10/11  14:21
 * @desc:
 */

@Controller
public class UserController {
    /**
     * 发送自由编辑的邮件
     *
     * @param toEmailAddress 收件人邮箱
     * @param emailTitle 邮件主题
     * @param emailContent 邮件内容
     * @return
     */
    @RequestMapping(value={"/sendEmailOwn"},method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String sendEmailOwn(@RequestParam("toEmailAddress") String toEmailAddress,
                               @RequestParam("emailTitle") String emailTitle,
                               @RequestParam("emailContent") String emailContent){
        try{
            //发送邮件
            SendmailUtil.sendEmail(toEmailAddress, emailTitle, emailContent);
            return "success";
        }catch(Exception e){
            return "fail";
        }
    }

}
