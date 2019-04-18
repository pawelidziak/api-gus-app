import {NgModule} from '@angular/core';
import {SearchCompanyComponent} from './search-company.component';
import {RouterModule, Routes} from '@angular/router';
import {CommonModule} from '@angular/common';
import {MatFormFieldModule, MatInputModule} from '@angular/material';
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
    MatInputModule
  ],
  providers: []
})
export class SearchCompanyModule {
}
