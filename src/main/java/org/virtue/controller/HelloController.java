package org.virtue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.virtue.service.MailService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    MailService mailService;

    @ResponseBody
    @RequestMapping(value = "/common/mail", method = {RequestMethod.GET})
    public String sendMail(){
        try {
            logger.debug("发送邮件");
            String subject = "测试普通邮件";
            String content = "测试普通邮件,邮件为系统发送，请勿回复！";
            mailService.sendMail("1249505842@qq.com", subject, content);
        } catch (Exception e) {
            logger.error("邮件发送失败，原因：{}",e.getMessage(),e);
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/attatch/mail", method = {RequestMethod.GET})
    public String sendAttatchMail(){
        try {
            logger.debug("附件邮件");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = dateFormat.format(new Date());
            String filePath = "file/attatch.txt";
            String content = "系统自动发送，"+" 发送日期："+format+",邮件为系统发送，请勿回复！";
            mailService.sendAttachmentsMail("1249505842@qq.com", "附件邮件", content,filePath);
        } catch (Exception e) {
            logger.error("邮件发送失败，原因：{}",e.getMessage(),e);
        }
        return "success";
    }
}
