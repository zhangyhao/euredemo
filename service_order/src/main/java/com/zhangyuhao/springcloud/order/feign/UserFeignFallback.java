package com.zhangyuhao.springcloud.order.feign;

import com.zhangyuhao.springcloud.User;
import org.springframework.stereotype.Component;

/**
 * UserFeignFallback来实现UserFeignClient
 * feignClient中指定fallback属性为UserFeignFallback
 */
@Component
public class UserFeignFallback implements UserFeignClient{
    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public User getUserByUser(User user) {
        User u = new User();
        u.setUsername("固定值");
        return u;
    }

    @Override
    public String getUsernameById(Integer id) {
        return null;
    }
}
