package com.doudou.bill.service.impl;

import com.doudou.bill.common.dto.DicDto;
import com.doudou.bill.orm.dao.DicDao;
import com.doudou.bill.service.DicService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DicServiceImpl implements DicService {

    @Autowired
    private DicDao dicDao;
    @Override
    public Map<String, List<DicDto>> mDiclist(String classIds) {
        if(StringUtils.isBlank(classIds)){

        }
        String[] ids = classIds.split(",");
        Map<String, List<DicDto>> map = new HashMap<String, List<DicDto>>();
        for (String classId:ids) {
            List<DicDto> list = dicDao.selectById(classId);
            map.put(classId,list);
        }
        return map;
    }
}
