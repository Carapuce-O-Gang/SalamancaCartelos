import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-my-group',
  templateUrl: './my-group.component.html',
  styleUrls: ['./my-group.component.css']
})
export class MyGroupComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  teamName: string = "Team 1";
  teamContent: string = "This is the team 1, we are the best";
  teamSubtitle: string = "We are team 1!"

  ngOnInit(): void {
  }

  openDialog(): void {
  }

}
