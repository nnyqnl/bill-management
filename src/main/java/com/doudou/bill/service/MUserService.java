package com.doudou.bill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.doudou.bill.common.constant.exception.GirlException;
import com.doudou.bill.common.dto.BillResult;
import com.doudou.bill.common.dto.UserDto;
import com.doudou.bill.orm.model.MUser;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nwq
 * @since 2018-10-29
 */
public interface MUserService extends IService<MUser> {

    BillResult login(UserDto userDto) throws GirlException;
}
