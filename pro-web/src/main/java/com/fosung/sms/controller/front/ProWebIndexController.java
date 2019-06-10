package com.fosung.sms.controller.front;

import com.fosung.framework.common.config.AppSecureProperties;
import com.fosung.framework.common.secure.auth.AppUserDetails;
import com.fosung.framework.common.util.UtilString;
import com.fosung.framework.web.http.AppIBaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/index")
public class ProWebIndexController extends AppIBaseController {

    @Autowired
    private AppSecureProperties appSecureProperties ;

    private String defaultFrontPage = "redirect:http://localhost:9528/" ;

    @GetMapping
    public String index(){
        AppUserDetails appUserDetails = getLoginAppUserDetails() ;
        String clientRegistrationId = appUserDetails.getClientRegistrationId() ;

        if(UtilString.isBlank( clientRegistrationId  )){
            log.info("没有找到登录的 clientRegistrationId");
            return defaultFrontPage ;
        }

        // 查询oauth2配置
        AppSecureProperties.OAuth2Config oAuth2Config = findOAuth2ConfigByRegistrationId( clientRegistrationId ) ;
        if( oAuth2Config == null ){
            log.info("跳转到一般登录页{}" , clientRegistrationId , oAuth2Config.getFrontPageUrl()) ;

            return defaultFrontPage ;
        }

        log.info("跳转到 {} 的登录页{}" , clientRegistrationId , oAuth2Config.getFrontPageUrl()) ;

        return "redirect:" + oAuth2Config.getFrontPageUrl() ;
    }

    /**
     * 根据注册id查询oauth2配置
     * @param registrationId
     * @return
     */
    public AppSecureProperties.OAuth2Config findOAuth2ConfigByRegistrationId(String registrationId) {
        if( appSecureProperties.getSso().getOauth2Configs()==null ||
                appSecureProperties.getSso().getOauth2Configs().size()<1 ){
            log.warn("没有配置oauth2认证信息");
            return null ;
        }

        for (AppSecureProperties.OAuth2Config oauth2Config : appSecureProperties.getSso().getOauth2Configs()) {
            if( UtilString.equalsIgnoreCase( oauth2Config.getRegistrationId() , registrationId ) ){
                return oauth2Config ;
            }
        }

        return null ;
    }

}
