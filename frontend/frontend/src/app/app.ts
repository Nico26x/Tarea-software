import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HelloService } from './core/services/hello.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],   // 👈 IMPORTANTE
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  mensaje: string = '';

  constructor(private helloService: HelloService) {}

  saludar() {
    this.helloService.getHello().subscribe(response => {
      this.mensaje = response;
    });
  }
}