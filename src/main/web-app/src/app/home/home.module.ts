import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { FileUploadModule } from 'primeng/fileupload';
import { TableModule } from 'primeng/table';
import { HttpClientModule } from '@angular/common/http';
import { MessageService } from 'primeng/api';

@NgModule({
  imports: [
    CommonModule,
    CardModule,
    ButtonModule,
    FileUploadModule,
    TableModule,
    HttpClientModule,
    HomeRoutingModule
  ],
  declarations: [HomeComponent],
  providers: [MessageService]
})
export class HomeModule { }
