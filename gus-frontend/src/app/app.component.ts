import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  appName = 'API GUS wyszukiwarka regon';

  openGitHub(): void {
    window.open('https://github.com/pawelidziak/api-gus-app', '_blank');
  }
}
