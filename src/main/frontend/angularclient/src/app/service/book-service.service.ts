import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Book } from '../model/book';

@Injectable()
export class BookService {

  private booksUrl = 'http://localhost:8080/books';

  constructor(private http: HttpClient) {
  }

  public findAllBooks() {
      return this.http.get(this.booksUrl);
  }

  public createBook(book: Book) {
      return this.http.post<Book>(this.booksUrl, book);
  }

  public updateBook(id: number, book: Book){
    const urlParams = new HttpParams().set("id", id.toString());
    return this.http.put(this.booksUrl, book, {params: urlParams});
  }

  public getBookById(id: number) {
      return this.http.get<Book>(this.booksUrl + "/" + id);
  }

  public deleteBook(id: Number){
      return this.http.delete(this.booksUrl + "/" + id);
  }
}
