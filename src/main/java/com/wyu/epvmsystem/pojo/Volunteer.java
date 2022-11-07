package com.wyu.epvmsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author afglow
 * @Date Create in 2022-10-2022/10/31-11:06
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("volunteer")
public class Volunteer {
    @TableId(value = "v_id",type = IdType.AUTO)
    private Integer vId;
    private String picPath;
    private String sId;
    private String vName;
    private String vPassword;
    private Integer sex;
    private String phone;
    private String cId;
    private String department;
    private String grade;
    private Integer vPoint;
    private Double vTime;
}
