import { Component, OnInit } from '@angular/core';
import {Author} from "../models/author";
import {AuthorServicesService} from "../services/author-services.service";
import {BookServicesService} from "../services/book-services.service";
import {BookShopServicesService} from "../services/book-shop-services.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  author?: Author[];
  currentAuthor: Author ={};
  currentIndex = -1;
  name = ''

  dtOptions: DataTables.Settings = {};

  constructor(private authorService: AuthorServicesService, private bookService: BookServicesService, private bookShopService:BookShopServicesService) { }

  ngOnInit(): void {
  }

  searchByAll(): void {
    this.currentAuthor = {};
    this.currentIndex = -1;


  }

}
