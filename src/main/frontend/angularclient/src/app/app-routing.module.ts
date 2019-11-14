import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import { BookFormComponent } from './book-form/book-form.component';
import {CarListComponent} from "./car-list/car-list.component";

const routes: Routes = [
  { path: 'books', component: BookListComponent },
  { path: 'addbook', component: BookFormComponent },
  { path: 'cars', component: CarListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
