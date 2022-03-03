package com.atguigu.srb.core.controller;


import com.atguigu.srb.core.pojo.entity.IntegralGrade;
import com.atguigu.srb.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author BigBing
 * @since 2021-05-11
 */
@CrossOrigin
@RestController
@Api(tags = " 网站接口管理")
@RequestMapping("/api/core/integralGrade")
public class IntegralGradeController {

    @Resource
    private IntegralGradeService integralGradeService;

    @ApiOperation("网站等级列表")
    @GetMapping("/weblist")
    public List<IntegralGrade> getAll(){
        return null;
    }
}

