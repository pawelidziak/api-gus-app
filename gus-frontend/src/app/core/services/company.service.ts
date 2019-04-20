import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Company} from '../models/company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http: HttpClient) {
  }

  getCompanyByNip(nip: string): Observable<Company> {
    return this.http.get<Company>('http://localhost:8080/getByNip', {params: {nip}});
  }
}
