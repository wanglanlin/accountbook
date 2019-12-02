package com.caacet.wll.service;

import com.caacet.wll.entity.AccountRecord;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRecordService {

    BigDecimal profitBy(Integer month,Integer year);
    BigDecimal totalIncomeBy(Integer month,Integer year);
    BigDecimal totalExpendBy(Integer month,Integer year);
    List<AccountRecord> allAccountBy(Integer month, Integer year);
    int insertSelective(AccountRecord record);

    int delAccountBy(Integer id);

    int updateByPK(AccountRecord record);
}
