package com.fosung.sms.controller.front;

import com.fosung.framework.common.json.JsonMapper;
import com.fosung.framework.common.secure.auth.AppUserDetails;
import com.fosung.framework.common.secure.auth.AppUserDetailsService;
import com.fosung.framework.common.util.UtilAuthentication;
import com.fosung.sms.controller.common.ProWebBaseController;
import com.fosung.framework.web.http.ResponseParam;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class ProWebFrontController extends ProWebBaseController {
    @Resource
    protected AppUserDetailsService appUserDetailsService;

    private AppUserDetails getAppUserDetails() {
        AppUserDetails appUserDetails = appUserDetailsService.getAppUserDetails();
        return appUserDetails;
    }

    /**
     * 登录用户的信息
     * @return
     */
    @RequestMapping("/info")
    public ResponseParam userInfo() {
        AppUserDetails appUserDetails = getAppUserDetails();

        // 结果数据
        Map<String, Object> result = Maps.newHashMap();
        if (appUserDetails != null) {
            result.put("roles", UtilAuthentication.convertGrantedAuthorityToRole(appUserDetails.getAuthorities()));
            result.put("name", appUserDetails.getUserRealName());
            result.put("avatar", "http://pic.qqtn.com/up/2017-12/2017120911584443954.jpg");
            result.put("orgName", appUserDetails.getOrgName());
            result.put("orgCode", appUserDetails.getOrgCode());
        }

        log.info("当前用户信息:{}" , JsonMapper.toJSONString( result ));

        return ResponseParam.success(appUserDetails != null ).data(result);
    }

}

