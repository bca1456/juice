import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookFormComponent } from './book-form/book-form.component';
import { BookService } from './service/book-service.service';
import { CarListComponent } from './car-list/car-list.component';
import {CarService} from "./service/car.service";

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    BookFormComponent,
    CarListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [BookService, CarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
