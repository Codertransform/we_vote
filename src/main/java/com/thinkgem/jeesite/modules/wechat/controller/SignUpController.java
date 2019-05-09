package com.thinkgem.jeesite.modules.wechat.controller;

import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.wechat.entity.SignUp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "${adminPath}/sign")
public class SignUpController extends BaseController {

    @ModelAttribute
    public SignUp get(@RequestParam(required = false) String id){
        SignUp entity = null;
        if (StringUtils.isNotBlank(id)){
//            entity =
        }else {
            entity = new SignUp();
        }
        return entity;
    }

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String signup(Model model){
        return "modules/wechat/signup";
    }

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public String signSave(){
        return null;
    }
}
