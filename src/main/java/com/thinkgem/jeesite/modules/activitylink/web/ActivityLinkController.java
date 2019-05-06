package com.thinkgem.jeesite.modules.activitylink.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.activity.entity.Activity;
import com.thinkgem.jeesite.modules.activity.service.ActivityService;
import com.thinkgem.jeesite.modules.activitylink.entity.ActivityLink;
import com.thinkgem.jeesite.modules.activitylink.service.ActivityLinkService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 活动链接Controller
 *
 * @author hww
 * @version 2019-03-21
 */
@Controller
@RequestMapping(value = "${adminPath}/activitylink/activityLink")
public class ActivityLinkController extends BaseController {

    @Autowired
    private ActivityLinkService activityLinkService;
    @Autowired
    private ActivityService activityService;

    @ModelAttribute
    public ActivityLink get(@RequestParam(required = false) String id) {
        ActivityLink entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = activityLinkService.get(id);
        }
        if (entity == null) {
            entity = new ActivityLink();
        }
        return entity;
    }

    @RequiresPermissions("activitylink:activityLink:view")
    @RequestMapping(value = {"list", ""})
    public String list(ActivityLink activityLink, HttpServletRequest request, HttpServletResponse response, Model model) {
        //查询所有活动
        Activity activity = new Activity();
        activity.setOffice(activityLink.getCurrentUser().getOffice());
        model.addAttribute("activityList", activityService.findList(activity));
        activityLink.setOffice(activityLink.getCurrentUser().getOffice());
        Page<ActivityLink> page = activityLinkService.findPage(new Page<ActivityLink>(request, response), activityLink);
        model.addAttribute("page", page);
        return "modules/activitylink/activityLinkList";
    }

    @RequiresPermissions("activitylink:activityLink:view")
    @RequestMapping(value = "form")
    public String form(ActivityLink activityLink, Model model) {
        Activity activity = new Activity();
        activity.setOffice(activityLink.getCurrentUser().getOffice());
        model.addAttribute("activityList", activityService.findList(activity));
        model.addAttribute("activityLink", activityLink);
        return "modules/activitylink/activityLinkForm";
    }

    @RequiresPermissions("activitylink:activityLink:edit")
    @RequestMapping(value = "save")
    public String save(ActivityLink activityLink, Model model, RedirectAttributes redirectAttributes) {
        activityLink.setOffice(activityLink.getCurrentUser().getOffice());
        ActivityLink isAlreadyExist = activityLinkService.getActivityLink(activityLink);
        if (isAlreadyExist != null) {
            addMessage(model,"该活动已经生成过连接");
            return form(activityLink, model);
        }
        if (!beanValidator(model, activityLink)) {
            return form(activityLink, model);
        }
        activityLinkService.save(activityLink);
        addMessage(redirectAttributes, "保存活动链接成功");
        return "redirect:" + Global.getAdminPath() + "/activitylink/activityLink/?repage";
    }

    @RequiresPermissions("activitylink:activityLink:edit")
    @RequestMapping(value = "delete")
    public String delete(ActivityLink activityLink, RedirectAttributes redirectAttributes) {
        activityLinkService.delete(activityLink);
        addMessage(redirectAttributes, "删除活动链接成功");
        return "redirect:" + Global.getAdminPath() + "/activitylink/activityLink/?repage";
    }

    /**
     * 生成活动连接
     * @param selectValue
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "produceUrl")
    public Map<String, Object> produceUrl(@RequestParam("selectValue") String selectValue, HttpServletRequest request) {
        return activityLinkService.produceUrl(selectValue,request);
    }

}