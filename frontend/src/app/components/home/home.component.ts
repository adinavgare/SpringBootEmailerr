import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { log } from 'console';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit
{
  constructor(private snack: MatSnackBar)
  {

  }
  ngOnInit(): void 
  {
    
  }

  btnClick()
  {
    console.log("Button Clicked")
    this.snack.open("Heyy! Welcome to this application", "cancle")
  }

}
