import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
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

  //типы шаблонов
  //TemplateRef используется для создания вложенных представлений
  @ViewChild('readOnlyTemp') readOnlyTemp: TemplateRef<any>; //шаблон онли для просмотра
  @ViewChild('editTemp') editTemp: TemplateRef<any>; //шаблон для редактирования
  // @ViewChild('addBookTemp') addBookTemp: TemplateRef<any>; //шаблон добавления книги
  //
  // showDialog(){
  //   let view = this.addBookModa
  // }

  constructor(private bookService: BookService) {
    this.books = new Array<Book>();
  }

  books: Array<Book>; //для хранения списка книг
  editedBook: Book; //изменяемая книга
  isNewRecord: boolean;

  //получение всех книг
  private fetchData(){
    this.bookService.findAllBooks().subscribe((data: Book[]) => {
        this.books = data;
    })
  }

  //при инциализации страницы
  ngOnInit() {
      this.fetchData();
  }

  // загружаем один из двух шаблонов
  loadTemplate(book: Book) {
    if (this.editedBook && this.editedBook.id == book.id) {
      return this.editTemp;
    } else {
      return this.readOnlyTemp;
    }
  }

  //редактирование книги
  updateBook(book: Book){
    this.editedBook = book;
  }

  // сохраняем книгу
  saveBook() {
    if (this.isNewRecord) {
      // добавляем книгу
      this.bookService.createBook(this.editedBook).subscribe(data => {
          this.fetchData();
      });
      this.isNewRecord = false;
      this.editedBook = null;
    } else {
      // изменяем книгу
      this.bookService.updateBook(this.editedBook.id, this.editedBook).subscribe(data => {
          this.fetchData();
      });
      this.editedBook = null;
    }
  }

  // отмена редактирования
  cancel() {
    // если отмена при добавлении, удаляем последнюю запись
    if (this.isNewRecord) {
      this.books.pop();
      this.isNewRecord = false;
    }
    this.editedBook = null; //обнуляем изменяемую книгу
    this.fetchData(); //получаем заново список
  }

  //удаление книги
  deleteBook(book: Book) {
      this.bookService.deleteBook(book.id).subscribe(() => {
          this.fetchData();
      });
  }



}
