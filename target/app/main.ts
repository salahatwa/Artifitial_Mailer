  import { bootstrap } from 'angular2/platform/browser';
  import { CountryListComponent } from './countrylistcomponent';

  bootstrap(CountryListComponent)
    .then(success => console.log(`Bootstrap success`))
    .catch(error => console.log(error));
