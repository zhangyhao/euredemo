package com.zhangyuhao.springcloud.order.feign;

import com.zhangyuhao.springcloud.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Component
@FeignClient(name = "service-user",fallback=UserFeignFallback.class)
public interface UserFeignClient {
    /**
     * 根据Id查询用户
     * @param id
     * @return
     */
    @RequestMapping("/user/getUserById")
    public User getUserById(@RequestParam("id") Integer id);

    @RequestMapping("/user/getUserByUser")
    public User getUserByUser(@RequestBody User user);

    /**
     * 根据Id查询用户名称
     * @param id
     * @return
     */
    @RequestMapping("/user/getUsernameById")
    public String getUsernameById(@RequestParam("id") Integer id);
}
