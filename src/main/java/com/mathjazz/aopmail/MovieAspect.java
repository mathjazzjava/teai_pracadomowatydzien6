package com.mathjazz.aopmail;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.mail.MessagingException;


@Aspect
@Component
public class MovieAspect {

        private MailService mailService;

        @Autowired
        public MovieAspect(MailService mailService) {
            this.mailService = mailService;
        }

        @After("@annotation(MovieAspectAnn)")
        public String sendMail() throws MessagingException {

            mailService.sendMail("****",
                    "Dodałeś film.",
                    "<b>Właśnie dodałeś do kolekcji nowy film.</b><br>:P", true);
            System.out.println("sendMail");
            return "wysłano";
        }
    }
