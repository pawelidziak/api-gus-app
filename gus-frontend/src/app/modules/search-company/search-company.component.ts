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
  nipControl: FormControl = new FormControl('', [
    Validators.required,
    Validators.minLength(10),
    Validators.maxLength(10),
    Validators.pattern('[0-9]*')
  ]);

  constructor(private formBuilder: FormBuilder, private service: CompanyService) {
  }

  ngOnInit() {
    this.searchCompanyForm = this.formBuilder.group({
      nip: this.nipControl
    });
  }

  searchCompany(): void {
    if (this.searchCompanyForm.valid) {
      this.service.getCompanyByNip(this.nipControl.value).subscribe(
        (res: Company) => {
          console.log(res.Gmina);
        },
        err => console.error(err)
      );
    }
  }
}
