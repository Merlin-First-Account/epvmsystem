package com.wyu.epvmsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author afglow
 * @Date Create in 2022-10-2022/10/31-16:35
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("activity")
public class Activity {
    @TableId(value = "a_id",type = IdType.AUTO)
    private Integer aId;
    private String aName;
    private Date bTime;
    private Date eTime;
    private Integer rId;
    private Integer vQuantity;
    private Double aTime;
    private Integer aPoint;
    private String aIntroduction;
}
