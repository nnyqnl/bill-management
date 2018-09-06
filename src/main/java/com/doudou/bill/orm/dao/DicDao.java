package com.doudou.bill.orm.dao;

import com.doudou.bill.common.dto.DicDto;

import java.util.List;

public interface DicDao {
    List<DicDto> selectById(String classId);
}
