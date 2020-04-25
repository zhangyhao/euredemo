package com.zhangyuhao.springcloud.order.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class DingDan implements Serializable {
    private Integer wid;
    private String wname;
    private Integer uid;
}
