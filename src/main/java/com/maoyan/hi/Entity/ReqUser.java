package com.maoyan.hi.Entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReqUser     {

    private Integer id;
    private String name;
    private String gender;

        @NotBlank(message = "用户名不能为空")
        public String getName() {
            return name;
        }

        @NotBlank(message = "密码不能为空")
        public String getGender() {
            return gender;
        }
}
