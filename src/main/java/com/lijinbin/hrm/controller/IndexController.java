package com.lijinbin.hrm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lijinbin.hrm.bean.Staff;
import com.lijinbin.hrm.common.R;
import com.lijinbin.hrm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    StaffService staffService;

    /**
     * 登录并验证密码和是否是管理员
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/login")
    public R<String> loginAdmin(String username, String password) {
        if (StringUtils.hasLength(username) && StringUtils.hasLength(password)) {
            QueryWrapper<Staff> staffQueryWrapper = new QueryWrapper<>();
            staffQueryWrapper.eq("sf_id", username).eq("is_admin", "1");
            Staff staff = staffService.getBaseMapper().selectOne(staffQueryWrapper);
            if (staff != null && staff.getSfPassword().equals(password)) return R.success("登录成功");
        }
        return R.error("登陆失败，账号或密码不正确");
    }

    /**
     * 普通用户登录打卡签到
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/loginUser")
    public R<Staff> loginUser(String username, String password) {
        if (StringUtils.hasLength(username) && StringUtils.hasLength(password)) {
            QueryWrapper<Staff> staffQueryWrapper = new QueryWrapper<>();
            staffQueryWrapper.eq("sf_id", username);
            Staff staff = staffService.getBaseMapper().selectOne(staffQueryWrapper);
            if (staff != null && staff.getSfPassword().equals(password)) return R.success(staff);
        }
        return R.error("登陆失败，账号或密码不正确");
    }
}
