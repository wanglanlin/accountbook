package com.caacet.wll.service.impl;

import com.caacet.wll.dao.AccountRecordMapper;
import com.caacet.wll.entity.AccountRecord;
import com.caacet.wll.service.AccountRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountRecordServiceImpl implements AccountRecordService {

    @Autowired
    private AccountRecordMapper accountRecordMapper;

    @Override
    public BigDecimal profitBy(Integer month, Integer year) {
        return accountRecordMapper.getProfitByMonth(month, year);
    }

    @Override
    public BigDecimal totalIncomeBy(Integer month, Integer year) {
        return accountRecordMapper.getTotalIncomeByMonth(month, year);
    }

    @Override
    public BigDecimal totalExpendBy(Integer month, Integer year) {
        return accountRecordMapper.getTotalSpendByMonth(month, year);
    }

    @Override
    public List<AccountRecord> allAccountBy(Integer month, Integer year) {
        return accountRecordMapper.getAllAmountByMonth(month, year);
    }

    @Override
    public int insertSelective(AccountRecord record) {
        return accountRecordMapper.insertSelective(record);
    }

    @Override
    public int delAccountBy(Integer id) {
        return accountRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPK(AccountRecord record) {
        return accountRecordMapper.updateByPrimaryKeySelective(record);
    }
}
