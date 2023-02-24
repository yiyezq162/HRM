package com.lijinbin.hrm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lijinbin.hrm.bean.Staff;
import com.lijinbin.hrm.common.R;
import com.lijinbin.hrm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/staff")
@RestController
public class StaffController {

    @Autowired
    StaffService staffService;

    /**
     * 查询某个部门的所有员工
     *
     * @param id
     * @return
     */
    @GetMapping("/dep/{id}")
    public R<List<Staff>> getList(@PathVariable("id") int id) {
        QueryWrapper<Staff> staffQueryWrapper = new QueryWrapper<>();
        staffQueryWrapper.in("sf_dep", id);
        List<Staff> staff = staffService.getBaseMapper().selectList(staffQueryWrapper);
        return R.success(staff);
    }

    /**
     * 根据id查询员工
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<Staff> update(@PathVariable("id") int id) {
        QueryWrapper<Staff> staffQueryWrapper = new QueryWrapper<>();
        staffQueryWrapper.in("sf_id", id);
        Staff staff = staffService.getBaseMapper().selectOne(staffQueryWrapper);
        return R.success(staff);
    }

    /**
     * 添加员工
     *
     * @param staff
     * @return
     */
    @PostMapping
    public R<String> add(Staff staff) {
        staff.setSfOnTime(LocalDateTime.now());
        boolean save = staffService.save(staff);
        if (save) {
            return R.success("添加成功");
        } else {
            return R.error("添加失败");
        }
    }

    /**
     * 修改员工
     *
     * @param staff
     * @return
     */
    @PutMapping
    public R<String> updateDo(Staff staff) {
        boolean update = staffService.updateById(staff);
        if (update) {
            return R.success("修改成功");
        } else {
            return R.error("修改失败");
        }
    }

    /**
     * 删除员工
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public R<String> remove(@PathVariable("id") int id) {
        boolean remove = staffService.removeById(id);
        if (remove) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    /**
     * 模糊查询
     *
     * @param search
     * @return
     */
    @PostMapping("/search")
    public R<List<Staff>> select(String search) {
        QueryWrapper<Staff> staffQueryWrapper = new QueryWrapper<>();
        staffQueryWrapper.like("sf_name", search).or().like("sf_age", search);
        List<Staff> staff = staffService.getBaseMapper().selectList(staffQueryWrapper);
        return R.success(staff);
    }

    /**
     * 清空今日打卡记录
     *
     * @return
     */
    @GetMapping("/emptyCheck")
    public R<String> emptyCheck() {
        UpdateWrapper<Staff> staffUpdateWrapper = new UpdateWrapper<>();
        staffUpdateWrapper.set("sf_check", "0");
        boolean update = staffService.update(null, staffUpdateWrapper);
        if (update) {
            return R.success("清空成功");
        } else {
            return R.error("清空失败");
        }
    }

    @GetMapping("/history")
    public R<List<Staff>> getAllHistory() {
        QueryWrapper<Staff> staffQueryWrapper = new QueryWrapper<>();
        staffQueryWrapper.orderByDesc("sf_lazy");
        List<Staff> staff = staffService.getBaseMapper().selectList(staffQueryWrapper);
        return R.success(staff);
    }

    @GetMapping("/today")
    public R<List<Staff>> getToday() {
        QueryWrapper<Staff> staffQueryWrapper = new QueryWrapper<>();
        staffQueryWrapper.eq("sf_check", "0");
        List<Staff> staff = staffService.getBaseMapper().selectList(staffQueryWrapper);
        return R.success(staff);
    }

    /**
     * 打卡
     *
     * @param id
     * @return
     */
    @GetMapping("/check/{id}")
    public R<Staff> check(@PathVariable("id") int id) {
        Staff staff = staffService.getBaseMapper().selectById(id);
        UpdateWrapper<Staff> staffUpdateWrapper = new UpdateWrapper<>();
        staffUpdateWrapper.eq("sf_id",id);
        staffUpdateWrapper.set("sf_check", "1");
        staffUpdateWrapper.set("sf_lazy", staff.getSfLazy() + 1);
        staffService.update(null, staffUpdateWrapper);
        staff = staffService.getBaseMapper().selectById(id);
        return R.success(staff);
    }
}
