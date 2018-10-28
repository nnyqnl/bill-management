package com.doudou.bill.service;

import com.doudou.bill.common.dto.BillResult;

public interface BookService {
    BillResult bookList();

    BillResult getById(String id);
}
