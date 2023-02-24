package com.lijinbin.hrm.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Staff {
    @TableId(type = IdType.AUTO)
    private int sfId;
    private String sfName;
    private String sfPassword;
    private Integer sfAge;
    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime sfOnTime;
    private String sfDep;
    private String isAdmin;
    private String sfCheck;
    private Integer sfLazy;
    private double sfSalary;
}
