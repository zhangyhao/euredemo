package com.zhangyuhao.springcloud.order.service;

import com.zhangyuhao.springcloud.order.entity.DingDan;
import com.zhangyuhao.springcloud.order.mapper.DingdanMapper;
import com.zhangyuhao.springcloud.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    DingdanMapper dingdanMapper;
    /**
     * 根据id查询order
     * @param id
     * @return
     */
    public Order getOrderById(Integer id){
        Order order = new Order();
        order.setId(id);
        order.setOrderno(System.currentTimeMillis()+"");
        order.setUserId(1);
        return order;
    }

    public List<DingDan> list() {
        return dingdanMapper.list();
    }
}
