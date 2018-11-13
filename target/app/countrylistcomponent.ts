import { Component } from 'angular2/core';
import { DataService } from './dataservice';
import { Country } from './country';
import { State } from './state';
import { City } from './city';

@Component({
  selector: 'my-country-list',
  templateUrl: 'app/countrylistcomponent.html',
  providers: [DataService]
})
export class CountryListComponent {
  selectedCountry:Country = new Country(0, 'India');
  selectedState:State =  new State(5, 2, 'Gujarat' );
  countries: Country[];
  states: State[];
  cities:City[];

  constructor(private _dataService: DataService) {
    this.countries = this._dataService.getCountries();
  }
  
  onSelect(countryid) {
    this.states = this._dataService.getStates().filter((item)=> item.countryid == countryid);
  }
  
  select(stateid){
    this.cities = this._dataService.getCities().filter((item)=> item.stateid == stateid);
    
  }
}
