import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Book } from '../model/book';

@Injectable()
export class BookService {

  private booksUrl = 'http://localhost:8080/books';

  constructor(private http: HttpClient) {
  }

  public findAll() {
    return this.http.get(this.booksUrl);
  }

  public save(book: Book) {
    return this.http.post<Book>(this.booksUrl, book);
  }

  public getById(id: number) {
    return this.http.get<Book>(this.booksUrl + "/" + id);
  }

  public delete(id: Number){
    return this.http.delete(this.booksUrl + "/" + id);
  }
}
