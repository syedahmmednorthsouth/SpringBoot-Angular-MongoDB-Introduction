package com.vinternship.mcmsbackend.models;

import org.springframework.data.annotation.Id;

import java.util.Arrays;

public class BookShop {
    @Id
    private  String id;
    private String title;
    private String shop_name;
    private String shop_number;
    private String location;
    private Book[] books;
    private int contact_no;
    private String email;

    public BookShop(String id,String title ,String shop_name, String shop_number, String location, Book[] books, int contact_no, String email) {
        this.id = id;
        this.title = title;
        this.shop_name = shop_name;
        this.shop_number = shop_number;
        this.location = location;
        this.books = books;
        this.contact_no = contact_no;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_number() {
        return shop_number;
    }

    public void setShop_number(String shop_number) {
        this.shop_number = shop_number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getContact_no() {
        return contact_no;
    }

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shop_name='" + shop_name + '\'' +
                ", shop_number='" + shop_number + '\'' +
                ", location='" + location + '\'' +
                ", books=" + Arrays.toString(books) +
                ", contact_no=" + contact_no +
                ", email='" + email + '\'' +
                '}';
    }
}


