import { Component, OnInit } from '@angular/core';

import {BookShop} from "../../../models/bookShop";

import {BookShopServicesService} from "../../../services/book-shop-services.service";
import {Book} from "../../../models/book";
import {BookServicesService} from "../../../services/book-services.service";

@Component({
  selector: 'app-add-book-shop',
  templateUrl: './add-book-shop.component.html',
  styleUrls: ['./add-book-shop.component.css']
})
export class AddBookShopComponent implements OnInit {
  db_books?: Book[];
  selected_books?:Book[];

  bookShop: BookShop = {
    title: '',
    shop_name: '',
    shop_number: 0,
    location: '',
    books: [],
    contact_no: 0,
    email: '',

  }

  submitted = false;

  constructor(private bookShopService: BookShopServicesService, private bookService: BookServicesService) { }
  ngOnInit(): void {
    this.bookService.getAll()
      .subscribe({
        next:(data)=>{
          this.db_books= data;

        },
        error:(err)=>{
          console.log(err)
        }
      });

    // this.genreService.getAll()
    //   .subscribe({
    //     next:(data)=>{
    //       this.db_genres = data;
    //     },
    //     error:(err)=>{
    //       console.log(err);
    //     }
    //   });

  }

  saveBookShop(): void {
    const data = {
      title: this.bookShop.title,
      shop_name: this.bookShop.shop_name,
      shop_number: this.bookShop.shop_number,
      location: this.bookShop.location,
      books: this.selected_books,
      contact_no: this.bookShop.contact_no,
      email: this.bookShop.email,
    };

    this.bookShopService.create(data)
      .subscribe(
        response => {
          console.log(response);
          console.log(data);
          this.submitted = true;
        },
        error => {
          console.log(error);
        }
      );
    }

    newBookShop():void {
      this.submitted = false;
      this.bookShop = {
        title: '',
        shop_name: '',
        shop_number: 0,
        location: '',
        books: [],
        contact_no: 0,
        email: '',

      };

      this.selected_books = [];
    }

  }






