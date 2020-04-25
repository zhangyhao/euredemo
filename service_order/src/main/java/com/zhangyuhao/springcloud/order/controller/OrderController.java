package com.zhangyuhao.springcloud.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhangyuhao.springcloud.User;
import com.zhangyuhao.springcloud.order.entity.DingDan;
import com.zhangyuhao.springcloud.order.feign.UserFeignClient;
import com.zhangyuhao.springcloud.order.model.Order;
import com.zhangyuhao.springcloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order/")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    /**
     * 根据Id查询订单
     * @param id
     * @return
     */
    @RequestMapping("getOrderById")
    @HystrixCommand(fallbackMethod = "getUserByUserFallback")
    public Order getOrderById(@RequestParam("id") Integer id){
        Order order = orderService.getOrderById(id);
        //service-user是被调用的服务名称 spring.application.name的名称
        //User user = restTemplate.getForObject("http://service-user/user/getUserById?id="+order.getUserId(), User.class);
        //User user = userFeignClient.getUserById(id);
        User userParam = new User();
        userParam.setId(1);
        User user = userFeignClient.getUserByUser(userParam);
        log.info("user:{}",user);
        order.setUsername(user.getUsername());
        return order;
    }

    /**
     * getUserByUserFallback方法的参数要个userFeignClient.getUserByUser参数一致
     * @param
     * @return
     */
    public Order getUserByUserFallback(Integer id){
        Order order = orderService.getOrderById(id);
        User userParm = new User();
        userParm.setUsername("固定值");
        return order;
    }

    @RequestMapping("list")
    public Object list(){

        List<DingDan> list = orderService.list();
        return list;
    }
}
