import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class CarService {

  private carsUrl = "http://localhost:8080/cars";

  constructor(private http: HttpClient) { }

  public findAllCars(){
    return this.http.get(this.carsUrl);
  }
}
