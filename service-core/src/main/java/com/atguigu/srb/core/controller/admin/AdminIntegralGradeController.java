package com.atguigu.srb.core.controller.admin;

import com.atguigu.common.exception.Assert;
import com.atguigu.common.result.R;
import com.atguigu.common.result.ResponseEnum;
import com.atguigu.srb.core.pojo.entity.IntegralGrade;
import com.atguigu.srb.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "积分等级管理")
@CrossOrigin
@RestController
@RequestMapping("/admin/core/integralGrade")
@Slf4j
public class AdminIntegralGradeController {
    
    @Resource
    private IntegralGradeService integralGradeService;

    @ApiOperation("积分等级列表")
    @GetMapping("/list")
    public R listAll(){
        log.info("this is log info");
        log.warn("this is log warn");
        log.error("this is log error");
        List<IntegralGrade> list = integralGradeService.list();
        return R.ok().data("list",list).message("获取列表成功");
    }

    @ApiOperation("根据Id,获取积分对象")
    @GetMapping("/getByid/{id}")
    public R getById(
            @ApiParam(value = "积分等级Id",required = true,example = "1")
            @PathVariable Integer id){
        IntegralGrade byIdGrade = integralGradeService.getById(id);
        if(byIdGrade != null){
            return R.ok().data("byIdGrade",byIdGrade).message("获取积分对象成功");
        }
        return R.error().message("获取积分对象失败");
    }

    @ApiOperation(value = "根据Id删除数据记录",notes = " 逻辑删除数据记录")
    @DeleteMapping("/remove/{id}")
    public R removeById(
            @ApiParam(value = " 数据ID",required = true,example = "1")
            @PathVariable long id){
        boolean result = integralGradeService.removeById(id);
        if(result){
          return  R.ok().message("删除成功");
        }
         return R.error().message("删除失败");

    }

    @ApiOperation(value = "新增积分等级")
    @PostMapping("/save")
    public R save(
            @ApiParam(value = "积分等级对象",required = true)
            @RequestBody IntegralGrade  integralGrade){
       /* if(integralGrade.getBorrowAmount() == null){
            throw new BusinessException(ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        }*/
        Assert.notNull(integralGrade.getBorrowAmount(), ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        boolean saveDj = integralGradeService.save(integralGrade);
        if(saveDj){
          return R.ok().message("新增成功");
        }
         return R.error().message("新增失败");
    }

    @ApiOperation(value = "更新积分等级")
    @PutMapping("/update")
    public R update(
            @ApiParam(value = "积分等级对象",required = true)
            @RequestBody IntegralGrade  integralGrade){
        boolean updateDj = integralGradeService.updateById(integralGrade);
        if(updateDj){
            return R.ok().message("更新成功");
        }
        return R.error().message("更新失败");
    }

}
