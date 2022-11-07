package com.wyu.epvmsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyu.epvmsystem.pojo.Activity;
import org.springframework.stereotype.Repository;

/**
 * @author afglow
 * @Date Create in 2022-10-2022/10/31-22:21
 * @Description
 */
@Repository
public interface ActivityMapper extends BaseMapper<Activity> {//BaseMapper是mybatis plus里面的，里面有基本的增删改查方法

}
