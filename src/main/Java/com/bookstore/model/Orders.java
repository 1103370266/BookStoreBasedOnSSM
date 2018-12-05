package com.bookstore.model;

public class Orders {
    private int orderId;
    private int id;
    private int bookId;
    private String bookName;
    private int orderNum;
    private String consignee;
    private int orderPrice;
    private int state;
    private String address;
    private String contactWay;


    public int getOrderId(){return orderId;}

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getId(){return id;}

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId(){return bookId;}

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName(){return bookName;}

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getOrderNum(){return orderNum;}

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getOrderPrice(){return orderPrice;}

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getState(){return  state;}

    public void setState(int state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }
}
