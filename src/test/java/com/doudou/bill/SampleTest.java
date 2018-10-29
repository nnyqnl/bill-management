package com.doudou.bill;

import com.doudou.bill.orm.dao.MBookDao;
import com.doudou.bill.orm.dao.MUserDao;
import com.doudou.bill.orm.model.MBook;


import com.doudou.bill.orm.model.MUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private MUserDao userDao;
    @Autowired
    private MBookDao mBookDao;


    @Test
    public void testSelect() {
        MBook mBook = mBookDao.selectById('1');
        System.out.println((mBook));

//        System.out.println(("----- selectAll method test ------"));
        MUser mUser = userDao.selectById("1");
        System.out.println(mUser.getLoginName());
//        List<MUser> mUsers = userDao.selectList(null);
//        System.out.println(mUsers);
//        mUsers.get(0).get


    }

}