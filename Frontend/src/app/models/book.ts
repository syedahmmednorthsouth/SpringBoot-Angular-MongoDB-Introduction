import {Author} from "./author";
import {Genre} from "./genre";

export class Book {
  id?: any;
  title?: string;
  price?: number;
  year_of_publication?: number;
  author?: Author[];
  genre?:Genre[];
  publisher?:string;
  // phone?: string;
  // email?: string;
  // genre?: string[];
  // registration?: Date;
}


// private  String id;
// private String title;
// private double price;
// private Year year_of_publishing;
// private Author[] author;
// private String genre;
// private String publisher;
