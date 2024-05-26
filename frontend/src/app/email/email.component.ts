import { Component, OnInit } from '@angular/core';
import { EmailSService } from '../service/email-s.service';
import { error } from 'console';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrl: './email.component.css'
})
export class EmailComponent implements OnInit 
{
  data = {
    to: "",
    subject: "",
    message: ""
  }

  flag=false;

  constructor(private email: EmailSService, private snak:MatSnackBar)
  {

  }

  ngOnInit(): void 
  {

  }

  doSubmitForm()
  {
    console.log("Try to submit form");
    console.log("DATA", this.data);


    if(this.data.to=="" || this.data.subject=="" || this.data.message=="")
    {
      this.snak.open("Fields Cannot be empty!!", "OK");
      return;
    }

    this.flag = true
    this.email.sendEmail(this.data).subscribe(
      response=>{
        console.log(response);
        this.flag=false;
        this.snak.open("Sent successfully", "OK");
      },
      error=>{
        console.log(error);
        this.flag=false;
        this.snak.open("Sent successfully", "OK")
      }
    )
  }
}
