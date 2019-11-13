import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from '../service/book-service.service';
import { Book } from '../model/book';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css'],
  providers: [BookService]
})
export class BookFormComponent {

  book: Book = new Book(1, "");
  bookName: string;

  constructor(
    private router: Router,
        private bookService: BookService) {
  }

  onSubmit(form: NgForm) {
    this.bookService.createBook(this.book)
      .subscribe(() => {
          //alert("form: " + form +"   id: " + this.book.name + "  name:" + this.book.name);
          this.gotoBookList()
      });
  }

  gotoBookList() {
    this.router.navigate(['/books']);
  }
}
