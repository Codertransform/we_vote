package com.thinkgem.jeesite.modules.production.web;

import com.thinkgem.jeesite.modules.activity.entity.Activity;
import com.thinkgem.jeesite.modules.activity.service.ActivityService;
import com.thinkgem.jeesite.modules.production.entity.MobileUser;
import com.thinkgem.jeesite.modules.production.entity.Production;
import com.thinkgem.jeesite.modules.production.service.MobileUserService;
import com.thinkgem.jeesite.modules.production.service.ProductionService;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: hww
 * @Date: 2019/5/4 16:39
 */
@Controller
@RequestMapping("/mobile/mobileUser")
public class MobileUserController {

    @Autowired
    private MobileUserService mobileUserService;

    @Autowired
    private ActivityService activityService;
    @Autowired
    private ProductionService productionService;

    @RequestMapping("/register")
    public String register(String activityId, Model model) {
        Activity activity = activityService.get(activityId);
        model.addAttribute("activity", activity);
        return "modules/mobile/userRegisterForm";
    }

    @RequestMapping("/doRegister")
    public String doRegister(MobileUser mobileUser, String activityId, Model model) {
        Activity activity = activityService.get(activityId);
        model.addAttribute("activity", activity);
        mobileUserService.addMobileUser(mobileUser);
        String message = "注册成功";
        model.addAttribute("message", message);
        return "modules/mobile/userLoginForm";
    }


    @RequestMapping("/login")
    public String login(String activityId, Model model, String message) {
        Activity activity = activityService.get(activityId);
        model.addAttribute("activity", activity);
        if (message != null) {

            model.addAttribute("message", message);
        }
        return "modules/mobile/userLoginForm";
    }

    @RequestMapping("/doLogin")
    public String doLogin(MobileUser mobileUser, String activityId, HttpServletRequest request, Model model) {

        MobileUser dataMobileUser = mobileUserService.getMobileUser(mobileUser);
        if (dataMobileUser == null) {
            String message = "用户名或者密码输入错误";
            return login(activityId, model, message);
        } else {
            request.getSession().setAttribute("mobileUser", dataMobileUser);
            return "redirect:/mobile/activity/activity/index?activityId=" + activityId;
        }
    }

    @RequestMapping("/onName")
    public String onName(String activityId, Model model, HttpServletRequest request) {
        MobileUser mobileUser = (MobileUser) request.getSession().getAttribute("mobileUser");
        if (mobileUser == null) {
            String message = "请先登录，在参加活动";
            return login(activityId, model, message);
        }
        Activity activity = activityService.get(activityId);
        model.addAttribute("activity", activity);
        return "modules/mobile/userOnNameForm";
    }

    @RequestMapping("/doOnName")
    public String doOnName(String activityId, String officeId, MultipartFile images, String remarks) throws IOException {
        /*上传文件*/
        String newFileName=null;
        if (images != null) {
            String filePath = "E:\\upload";
            String originalFileName = images.getOriginalFilename();
            newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
            //新文件
            File file = new File(filePath + newFileName);
            //写入磁盘
            images.transferTo(file);
        }
        Production production=new Production();
        Activity activity=new Activity();
        activity.setId(activityId);
        Office office=new Office();
        office.setId(officeId);
        production.setOffice(office);
        production.setOffice(office);
        production.setImage(newFileName);
        productionService.save(production);
        return "redirect:/mobile/activity/activity/index?activityId=" + activityId;
    }
}
