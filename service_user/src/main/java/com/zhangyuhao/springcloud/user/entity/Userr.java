package com.zhangyuhao.springcloud.user.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Userr implements Serializable {
    private Integer id;
    private String name;
    private String sex;
}
