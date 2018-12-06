package com.bookstore.service.impl;

import com.bookstore.dao.OrdersDao;
import com.bookstore.model.Orders;
import com.bookstore.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//注解
public class OrdersServicelmpl implements OrdersService{
    @Autowired//自动装配
            OrdersDao OrdersDao;

    @Override
    public  List<Orders> showOrdersById(int id){
        List<Orders> ordersList=OrdersDao.showOrdersById(id);
        return  ordersList;
    }

    @Override
    public boolean addOrder(int id, int bookId, String bookName,
                            int orderNum, String consignee, String address, String contactWay,int orderPrice) {
        Orders orders=new Orders();
        OrdersDao.addOrder(id,bookId,bookName,orderNum,consignee,address,contactWay,orderPrice);
        return true;
    }

    @Override
    public int getOrderCountByUserId(int id){
        return OrdersDao.getOrderCountByUserId(id);
    }

}
