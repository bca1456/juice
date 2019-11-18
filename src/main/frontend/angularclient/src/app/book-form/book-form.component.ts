import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {BookService} from '../service/book-service.service';
import {Book} from '../model/book';
import {FormBuilder, FormControl, FormGroup, NgForm, Validators} from "@angular/forms";

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css'],
  providers: [BookService]
})
export class BookFormComponent implements OnInit{

  book: Book = new Book(1, "");
  bookName: string;

  dadaString: FormControl = new FormControl('q');
  dadaFormGroup: FormGroup;

  constructor(
    private router: Router,
        private bookService: BookService,
          private formBuilder: FormBuilder) {
  }

  ngOnInit(){
    this.dadaFormGroup = this.formBuilder.group({
      firstName: [null, [Validators.required,
                          Validators.minLength(1),
                          Validators.pattern(/^[A-z]/)]],
      firstNameRus: [null, [Validators.required,
                            Validators.minLength(1),
                            Validators.pattern(/^[А-я]/)]],
      secondName: [null, [Validators.required,
                          Validators.minLength(1)]],
      email: [null, [Validators.required,
                      Validators.email]],
      age: [null, [Validators.required,
                    Validators.min(1),
                    Validators.max(150),
                    Validators.pattern(/^[0-9]/)]],
      star: [null, [Validators.required,
                    Validators.pattern(/[*]/)]]
    });
  }

  eshkere(){
    // alert(this.dadaFormGroup.value.firstName  + " "
    //   this.dadaFormGroup.value.secondName + " "
    //   this.dadaFormGroup.value.email + " "
    //   this.dadaFormGroup.value.age);
  }

  isControlInvalid(controlName: string): boolean {
    const control = this.dadaFormGroup.controls[controlName];

    return control.invalid && control.touched;
  }

  onSubmit(form: NgForm) {
    alert(this.dadaFormGroup.value.firstName);
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
