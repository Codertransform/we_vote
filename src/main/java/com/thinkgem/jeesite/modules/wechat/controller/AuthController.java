package com.thinkgem.jeesite.modules.wechat.controller;

import com.thinkgem.jeesite.modules.wechat.util.CheckUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping(value = "${adminPath}/auth")
public class AuthController {

    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    public void anth(HttpServletRequest request, HttpServletResponse response){
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (CheckUtil.checkSignatrue(signature,timestamp,nonce)){
            out.print(echostr);
        }
    }

}
