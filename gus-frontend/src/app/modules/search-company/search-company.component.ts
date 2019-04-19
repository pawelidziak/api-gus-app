import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

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

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.searchCompanyForm = this.formBuilder.group({
      nip: this.nipControl
    });
  }

  searchCompany(): void {
    if (this.searchCompanyForm.valid) {
      console.log(this.searchCompanyForm.value);
    }
  }
}
