import { Component, OnInit } from '@angular/core';
import { select, Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Producto, SesionUsuario } from '../interfaces';
import { initialSesionUsuario } from '../reducer';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.scss']
})
export class CarritoComponent implements OnInit {
  sesionUsuario$ : Observable<any>;  
  sesionUsuario : SesionUsuario;
  lista: Producto[] = [];
  constructor(private storeSesion: Store<{sesionUsuario: any}>) { }

  ngOnInit(): void {
    this.sesionUsuario = initialSesionUsuario;    
    this.sesionUsuario$ = this.storeSesion.pipe(select('sesionUsuario'));    
    this.sesionUsuario$.subscribe( reaccion => {      
      this.lista = reaccion.lista;
    });
  }

}
