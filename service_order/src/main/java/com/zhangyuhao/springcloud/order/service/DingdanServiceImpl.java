package com.zhangyuhao.springcloud.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangyuhao.springcloud.order.entity.DingDan;
import com.zhangyuhao.springcloud.order.mapper.DingdanMapper;
import com.zhangyuhao.springcloud.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DingdanServiceImpl{

    @Autowired
    DingdanMapper dingdanMapper;


    public List<DingDan> list() {
        return dingdanMapper.list();
    }
}
