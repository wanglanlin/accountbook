package com.caacet.wll.controller;

import com.caacet.wll.entity.AccountRecord;
import com.caacet.wll.service.AccountRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@Api(value = "AccountRecordController", description = "账单信息的一些接口 -- 王栏淋")
@RequestMapping("account")
public class AccountRecordController {

    private final AccountRecordService accountRecordService;

    @Autowired
    public AccountRecordController(AccountRecordService accountRecordService) {
        this.accountRecordService = accountRecordService;
    }


    @ApiOperation(value="获取对应年月的利润", notes=" by 王栏淋 ")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "month", value = "月份", dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "year", value = "年份", dataType = "int")

    })
    @RequestMapping(value = "profit",method = RequestMethod.GET)
    @ResponseBody
    public String profitBy(@RequestParam(value = "month") Integer month, @RequestParam(value = "year") Integer year) {
        BigDecimal profit = accountRecordService.profitBy(month,year);
        System.out.println(month+"月份的利润是"+profit);
        return year+"年"+month+"月 的利润是："+profit;
    }

    @ApiOperation(value="获取对应年月的总收入", notes=" by 王栏淋 ")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "month", value = "月份", dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "year", value = "年份", dataType = "int")

    })
    @RequestMapping(value = "total/income",method = RequestMethod.GET)
    @ResponseBody
    public String totalIncomeBy(@RequestParam(value = "month") Integer month, @RequestParam(value = "year") Integer year) {
        BigDecimal totalIncome = accountRecordService.totalIncomeBy(month,year);
        return year+"年"+month+"月 的总收入是："+totalIncome;
    }

    @ApiOperation(value="获取对应年月的总支出", notes=" by 王栏淋 ")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "month", value = "月份", dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "year", value = "年份", dataType = "int")

    })
    @RequestMapping(value = "total/expend",method = RequestMethod.GET)
    @ResponseBody
    public String totalExpendBy(@RequestParam(value = "month") Integer month, @RequestParam(value = "year") Integer year) {
        BigDecimal totalExpend = accountRecordService.totalExpendBy(month,year);
        return year+"年"+month+"月 的总支出是："+totalExpend;
    }

    @ApiOperation(value="获取对应年月的总支出", notes=" by 王栏淋 ")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "month", value = "月份", dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "year", value = "年份", dataType = "int")

    })
    @RequestMapping(value = "all",method = RequestMethod.GET)
    @ResponseBody
    public List<AccountRecord> allAccountBy(@RequestParam(value = "month") Integer month, @RequestParam(value = "year") Integer year) {
        List<AccountRecord> accountRecords = accountRecordService.allAccountBy(month,year);
        return accountRecords;
    }

    @ApiOperation(value="新增账单记录", notes=" by 王栏淋 ")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id", value = "自动生成，无需输入", dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "name", value = "账目名称", dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "type", value = "账目类型，1：收入，-1：支出", dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "content", value = "内容", dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "note", value = "备注：如购物物品为钢笔、苹果", dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "amount", value = "金额", dataType = "BigDecimal"),
            @ApiImplicitParam(paramType = "query",name = "time", value = "日期", dataType = "Date")

    })
    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public String addAccountBy(AccountRecord record) {
        record.setId(null);
        int result = accountRecordService.insertSelective(record);
        return result>0?"新增成功":"新增失败";
    }

    @ApiOperation(value="根据主键id，删除记录", notes=" by 王栏淋 ")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id", value = "主键", dataType = "int")

    })
    @RequestMapping(value = "del",method = RequestMethod.GET)
    @ResponseBody
    public String delAccountBy(@RequestParam(value = "id") Integer id) {
        int result = accountRecordService.delAccountBy(id);
        return result>0?"删除成功":"删除失败";
    }

}
