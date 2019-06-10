package com.fosung.sms.controller.common.dto;

import com.fosung.framework.common.dto.support.DTOCallbackHandlerAdaptor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Setter
@Getter
@Slf4j
public class AppDTOCallbackHandlerDemo extends DTOCallbackHandlerAdaptor {

    @Override
    public <T> void preHandle(List<Map<String, Object>> dtoMapList, Class<?> itemClass) {
        log.info("dto处理:{}" , itemClass.getSimpleName()) ;
    }

}
