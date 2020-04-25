package com.zhangyuhao.springcloud.user.service;

import com.zhangyuhao.springcloud.User;
import com.zhangyuhao.springcloud.user.entity.Userr;
import com.zhangyuhao.springcloud.user.mapper.UserrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserrMapper userrMapper;
    /**
     * 根据id查询user
     * @param id
     * @return
     */
    public User getUserById(Integer id){
        User user = new User();
        user.setId(id);
        user.setUsername("userName:"+id);
        return user;
    }

    /**
     * 根据Id，查询用户名称
     * @param id
     * @return
     */
    public String getUsernameById(Integer id){
        User user = getUserById(id);
        return user.getUsername();
    }

    public List<Userr> list() {
        return userrMapper.list();
    }
}
