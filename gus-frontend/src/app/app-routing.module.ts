import {NgModule} from '@angular/core';
import {Routes, RouterModule, PreloadAllModules} from '@angular/router';

const routes: Routes = [
  {
    path: 'search',
    loadChildren: './modules/search-company/search-company.module#SearchCompanyModule'
  },
  {
    path: 'about',
    loadChildren: './modules/about/about.module#AboutModule'
  },
  {path: '**', redirectTo: '/search', pathMatch: 'full'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {
      preloadingStrategy: PreloadAllModules,
    })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
