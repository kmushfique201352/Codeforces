package com.example.universitymanagementlibrary;

import java.sql.Blob;

public class BookList_Users {
    int BID,Price,Qty;
    String BName,Author;
    Blob Cover;

    public BookList_Users(int BID, int price, int qty, String BName, String author, Blob cover) {
        this.BID = BID;
        Price = price;
        Qty = qty;
        this.BName = BName;
        Author = author;
        Cover = cover;
    }

    public int getBID() {
        return BID;
    }

    public void setBID(int BID) {
        this.BID = BID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public String getBName() {
        return BName;
    }

    public void setBName(String BName) {
        this.BName = BName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Blob getCover() {
        return Cover;
    }

    public void setCover(Blob cover) {
        Cover = cover;
    }
}
