package com.doudou.bill.service.impl;

import com.doudou.bill.common.dto.BillResult;
import com.doudou.bill.common.dto.BookDto;
import com.doudou.bill.common.dto.UserDto;
import com.doudou.bill.orm.dao.BookDao;
import com.doudou.bill.orm.model.Book;
import com.doudou.bill.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public BillResult bookList() {
        List<Book> list = bookDao.bookList();
        List<BookDto> dtoList = new ArrayList();
        for (Book b:list) {
            BookDto bdto = new BookDto();
            BeanUtils.copyProperties(b,bdto);
            dtoList.add(bdto);
        }

        return BillResult.ok(dtoList);
    }

    @Override
    public BillResult getById(String id) {
        Book b =  bookDao.getById(id);

        BookDto bookDto = new BookDto();
        bookDto.setId(id);
        bookDto.setBookName(b.getBookName());
        bookDto.setIntroduction(b.getIntroduction());
        bookDto.setCreateTime(b.getCreateTime());
        bookDto.setUpdateTime(b.getUpdateTime());

        return BillResult.ok(bookDto);
    }
}
