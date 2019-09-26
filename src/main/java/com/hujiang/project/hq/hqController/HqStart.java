package com.hujiang.project.hq.hqController;

import org.lebo.facegate.Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/api/hqStart",method = RequestMethod.POST)
public class HqStart {



        @RequestMapping("/start")
        public void hqStart(){
            System.out.println("=============开始===========");
            Client client = new Client();
            client.start();
        }
    }

