package com.bookstore.model;

public class Book {
    private int bookId;
    private String bookName;
    private int price;
    private String bookType;
    private String image;
    private String introduction;
    private String author;
    private String  press;
    private int inventory;

    public Book() {
    }

    public Book(int bookId, String bookName, int price, String bookType, String image, String introduction, String author, String press, int inventory) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.bookType = bookType;
        this.image = image;
        this.introduction = introduction;
        this.author = author;
        this.press = press;
        this.inventory = inventory;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPrice() {
        return price;
    }

    public String getBookType() {
        return bookType;
    }

    public String getImage() {
        return image;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getAuthor() {
        return author;
    }

    public String getPress() {
        return press;
    }

    public int getInventory() {
        return inventory;
    }
}
