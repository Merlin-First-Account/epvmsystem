package com.wyu.epvmsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author afglow
 * @Date Create in 2022-11-2022/11/2-18:26
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("administrators")
public class Admin {
    @TableId(value = "ad_id",type = IdType.AUTO)
    private Integer adId;
    private String adName;
    private String adPassword;
}
