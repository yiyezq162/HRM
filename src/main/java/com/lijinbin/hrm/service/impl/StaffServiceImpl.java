package com.lijinbin.hrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lijinbin.hrm.bean.Staff;
import com.lijinbin.hrm.mapper.StaffMapper;
import com.lijinbin.hrm.service.StaffService;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {
}
