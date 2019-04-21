import {NgModule} from '@angular/core';
import {AboutComponent} from './about.component';
import {RouterModule, Routes} from '@angular/router';
import {CommonModule} from '@angular/common';
import {MatButtonModule, MatCardModule, MatIconModule} from '@angular/material';

const routes: Routes = [
  {
    path: '', component: AboutComponent
  }
];

@NgModule({
  declarations: [
    AboutComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MatCardModule,
    MatButtonModule,
    MatIconModule
  ],
  providers: []
})
export class AboutModule {
}
