package com.zhangyuhao.springcloud.user.mapper;

import com.zhangyuhao.springcloud.user.entity.Userr;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserrMapper {
    @Select("select * from t_user")
    List<Userr> list();
}
