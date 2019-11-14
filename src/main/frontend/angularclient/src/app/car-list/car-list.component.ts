import { Component, OnInit } from '@angular/core';
import {CarService} from "../service/car.service";
import {Car} from "../model/car";

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css'],
  providers: [CarService]
})
export class CarListComponent implements OnInit {

  cars: Array<Car>;
  editedCar: Car;
  isNewRecord: boolean;

  constructor(private carService: CarService) {
    this.cars = new Array<Car>();
  }

  private fetchData(){
    this.carService.findAllCars().subscribe( (data : Array<Car>) => {
      this.cars = data;
    })
  }

  ngOnInit() {
    this.fetchData();
  }

}
