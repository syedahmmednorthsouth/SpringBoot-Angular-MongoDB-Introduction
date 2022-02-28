import {Genre} from "./genre";

export class Author {
  id?: any;
  name?: string;
  age?: number;
  phone?: string;
  email?: string;
  genre?: Genre[];
  registration?: Date;
}

// @Id
// private String id;
// private String name;
// private int age;
// private String phone;
// private String email;
// private List<String> genre;
// @CreatedDate
// private Date registration;
