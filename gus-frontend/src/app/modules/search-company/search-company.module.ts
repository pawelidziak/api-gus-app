import {NgModule} from '@angular/core';
import {SearchCompanyComponent} from './search-company.component';
import {RouterModule, Routes} from '@angular/router';
import {CommonModule} from '@angular/common';
import {
  MatButtonModule,
  MatCardModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule,
  MatProgressSpinnerModule
} from '@angular/material';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

const routes: Routes = [
  {
    path: '', component: SearchCompanyComponent
  }
];

@NgModule({
  declarations: [
    SearchCompanyComponent,
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatCardModule,
    MatButtonModule,
    MatProgressSpinnerModule
  ],
  providers: []
})
export class SearchCompanyModule {
}
