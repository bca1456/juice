import { Component, OnInit } from '@angular/core';
import { Book } from '../model/book';
import { BookService } from '../service/book-service.service';
import {Observable} from "rxjs";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
  providers: [BookService]
})
export class BookListComponent implements OnInit {

  books: Array<Book>;

  constructor(private bookService: BookService) {
    this.books = new Array<Book>();
  }

  fetchData(){
    this.bookService.findAll().subscribe((data: Book[]) => {
      this.books = data;
    })
  }

  ngOnInit() {
    this.fetchData();
  }

  deleteBook(book: Book) {
    this.bookService.delete(book.id).subscribe(() => {
        this.fetchData();
    });
  }
}
