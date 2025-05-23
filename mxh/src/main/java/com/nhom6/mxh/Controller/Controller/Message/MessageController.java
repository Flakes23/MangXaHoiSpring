package com.nhom6.mxh.Controller.Controller.Message;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    @GetMapping("/messagesmobile")
    public String getMessagePageMobile() {
        return "/User/Message/Mobile/Message";
    }

    @GetMapping("/chatmobile")
    public String getMessagePageChatMobile() {
        return "/User/Message/Mobile/Chat";
    }

    @GetMapping("/messages")
    public String getMessagePage() {

        return "/User/Message/Web/Messager";
    }
    

}
