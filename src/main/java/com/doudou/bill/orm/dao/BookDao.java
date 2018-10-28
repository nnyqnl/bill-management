package com.doudou.bill.orm.dao;

import com.doudou.bill.orm.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> bookList();

    Book getById(String id);
}
