package com.lijinbin.hrm.controller;


import com.lijinbin.hrm.bean.Dep;
import com.lijinbin.hrm.common.R;
import com.lijinbin.hrm.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/department")
@RestController
public class DepController {

    @Autowired
    DepService depService;

    /**
     * 返回全部的部门列表
     * @return
     */
    @GetMapping
    public R<List<Dep>> getDepList() {
        List<Dep> allDep = depService.getBaseMapper().selectList(null);
        return R.success(allDep);
    }

}
