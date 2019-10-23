package com.fosung.pro.rest.common.dto;

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

    /*DTO（Data Transfer Object）：数据传输对象，
    这个概念来源于J2EE的设计模式，原来的目的
    是为了EJB的分布式应用提供粗粒度的数据实体，
    以减少分布式调用的次数，从而提高分布式调用的
    性能和降低网络负载，但在这里，我泛指用于展示层与服务层之间的数据传输对象。*/
    @Override
    public <T>  void preHandle(List<Map<String, Object>> dtoMapList, Class<?> itemClass) {
        log.info("dto处理:{}" , itemClass.getSimpleName()) ;
    }

}
