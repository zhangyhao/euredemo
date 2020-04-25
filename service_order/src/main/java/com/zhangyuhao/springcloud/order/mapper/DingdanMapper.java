package com.zhangyuhao.springcloud.order.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangyuhao.springcloud.order.entity.DingDan;
import com.zhangyuhao.springcloud.order.model.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DingdanMapper {
    @Select("select * from t_dingdan")
    List<DingDan> list();
}
