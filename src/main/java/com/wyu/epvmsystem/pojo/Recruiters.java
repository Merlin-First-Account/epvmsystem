package com.wyu.epvmsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author afglow
 * @Date Create in 2022-10-2022/10/31-16:47
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("recruiters")
public class Recruiters {
    @TableId(value = "r_id",type = IdType.AUTO)
    private Integer rId;//招募者主键
    private String department;//院系
    private String wId;//招募者工作ID（教号登录用）
    private String rName;//招募者姓名
    private String rPassword;//招募者密码
    private Integer sex;//性别
    private String phone;//电话号码
}
