package com.maoyan.hi.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;


@Data
public class User  {
    @TableField("id")
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("gender")
    private int gender;
    public User(){

    }
}
