package com.fosung.pro.entity;

import com.fosung.framework.common.support.dao.entity.AppJpaBaseEntity;
import com.fosung.framework.common.support.dao.entity.AppJpaIdEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity//(name="user_2019_10")//表明该类 (UserEntity) 为一个实体类，它默认对应数据库中的表名是user
@Table(name="user_2019_10")//@Table 当实体类与其映射的数据库表名不同名时需要使用
@Getter
@Setter
@ToString
public class User extends AppJpaBaseEntity {//

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)//自动增长
//      @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
//    private String id;//Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "pass_word")
    private String passWord;
    @Column(name = "real_name")
    private String realName;
}
