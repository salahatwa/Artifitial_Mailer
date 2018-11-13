import { Injectable } from 'angular2/core';
import { Country } from './country';
import { State } from './state';
import { City } from './city';


@Injectable()
export class DataService {
  getCountries() {
    return [
     new Country(1, 'USA' ),
     new Country(2, 'India' ),
     new Country(3, 'Australia' )
    ];
  }
  
  getStates() {
   return [
     new State(1, 1, 'Arizona' ),
     new State(2, 1, 'Alaska' ),
     new State(3, 1, 'Florida'),
     new State(4, 1, 'Hawaii'),
     new State(5, 2, 'Gujarat' ),
     new State(6, 2, 'Goa'),
     new State(7, 2, 'Punjab' ),
     new State(8, 3, 'Queensland' ),
     new State(9, 3, 'South Australia' ),
     new State(10, 3, 'Tasmania')
    ];
  }
  
  
  getCities() {
   return [
     new City(1, 1, 'chennai' ),
     new City(2, 1, 'vellore' ),
     new City(3, 1, 'mmm'),
     new City(4, 1, 'yyy'),
     new City(5, 2, 'kolkata' ),
     new City(6, 2, 'rishra'),
     new City(7, 2, 'bhub' ),
     new City(8, 3, 'cddd' ),
     new City(9, 3, 'eww' ),
     new City(10, 3, 'wdw')
    ];
  }
}
