import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from "@angular/router";
import { HomeComponent } from './components/home/home.component';
import { AuthorListComponent } from './components/author-list/author-list.component';
import { AddAuthorComponent } from './components/add-author/add-author.component';
import { AuthorDetailsComponent } from './components/author-details/author-details.component';
import { AuthorUpdateComponent } from './components/author-update/author-update.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    AuthorListComponent,
    AddAuthorComponent,
    AuthorDetailsComponent,
    AuthorUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
