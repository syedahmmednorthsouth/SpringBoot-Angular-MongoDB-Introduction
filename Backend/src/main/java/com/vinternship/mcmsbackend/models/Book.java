package com.vinternship.mcmsbackend.models;

import org.springframework.data.annotation.Id;

import java.time.Year;

public class Book {

    @Id
    private  String id;
    private String title;
    private double price;
    private Year year_of_publishing;
    private Author[] author;
    private Genre[] genre;
    private String publisher;



    public Book(String id, String title, double price, Year year_of_publishing, Author[] author, Genre[] genre, String publisher) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.year_of_publishing = year_of_publishing;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Year getYear_of_publishing() {
        return year_of_publishing;
    }

    public void setYear_of_publishing(Year year_of_publishing) {
        this.year_of_publishing = year_of_publishing;
    }

    public Author[] getAuthor() {
        return author;
    }

    public void setAuthor(Author[] author) {
        this.author = author;
    }

    public Genre[] getGenre() {
        return genre;
    }

    public void setGenre(Genre[] genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", year_of_publishing=" + year_of_publishing +
                ", author=" + author +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
