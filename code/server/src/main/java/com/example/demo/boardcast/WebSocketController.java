package com.example.demo.boardcast;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**

 * WebSocketController
 */
@Controller
@RequestMapping("/socket")
public class WebSocketController {


    /**
     * 输入消息的页面
     * @return
     */
    @GetMapping("/send")
    public String sendMsg(){
        return "server";
    }

    /**
     * 推送数据接口
     * @Param message
     * @return
     */
    @RequestMapping("/push")
    public String pushMsg(@RequestParam("message")String message) {
        try {
            WebSocketServer.sendInfo(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "server";
    }
}