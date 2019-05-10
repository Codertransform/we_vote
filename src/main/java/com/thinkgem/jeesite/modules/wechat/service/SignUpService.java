package com.thinkgem.jeesite.modules.wechat.service;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wechat.dao.SignUpDao;
import com.thinkgem.jeesite.modules.wechat.entity.SignUp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SignUpService extends CrudService<SignUpDao, SignUp> {

}
