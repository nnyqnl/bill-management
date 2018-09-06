package com.doudou.bill.service;

import com.doudou.bill.common.dto.DicDto;

import java.util.List;
import java.util.Map;

public interface DicService {
    Map<String,List<DicDto>> mDiclist(String classIds);
}
