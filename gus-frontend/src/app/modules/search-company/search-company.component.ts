import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {CompanyService} from '../../core/services/company.service';
import {Company} from '../../core/models/company';

@Component({
  selector: 'app-search-company',
  templateUrl: './search-company.component.html',
  styleUrls: ['./search-company.component.scss']
})
export class SearchCompanyComponent implements OnInit {
  searchCompanyForm: FormGroup;
  nipControl: FormControl = new FormControl('8971696669', [
    Validators.required,
    Validators.minLength(10),
    Validators.maxLength(10),
    Validators.pattern('[0-9]*')
  ]);
  companyData: Company;
  loading: boolean;
  errorMsg: string;

  constructor(private formBuilder: FormBuilder, private service: CompanyService) {
  }

  ngOnInit() {
    this.searchCompanyForm = this.formBuilder.group({
      nip: this.nipControl
    });
  }

  searchCompany(): void {
    if (this.searchCompanyForm.valid) {
      this.loading = true;
      this.companyData = null;
      this.service.getCompanyByNip(this.nipControl.value).subscribe(
        (res: Company) => {
          this.companyData = res;
          this.loading = false;
        },
        (err: ErrorEvent) => {
          this.errorMsg = err.error.message;
          this.loading = false;
        }
      );
    }
  }
}
