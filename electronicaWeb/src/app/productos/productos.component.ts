import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { ApiService } from '../api.service';
import { Producto, SesionUsuario } from '../interfaces';
import * as action from './../action';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.scss']
})
export class ProductosComponent implements OnInit {
  nombre: string = '';
  lista: Producto[] = [];
  listaProducto: Producto[] = [];
  constructor(private api: ApiService, private storeSesion: Store<{sesionUsuario: any}>,
    private route: Router) { }

  ngOnInit(): void {
  }
  buscar():void{
    console.log(this.nombre);
    const producto: Producto = {
      id: undefined,
      marca: {
        id: undefined,
        nombre: undefined
      },
      nombre: this.nombre,
      peso: undefined,
      precioRegular: undefined,
      precioOferta: undefined,
      oferta: undefined,
      calificacion: undefined,
      urlImagen: undefined
    }
    this.api.obtenerProductos(producto).subscribe( respuesta =>{
      this.lista = respuesta.lista;
    });
  }
  agregarProducto(indice: number): void{
    const producto:Producto = this.lista[indice];
    this.listaProducto.push(producto);
    console.log(this.listaProducto);
    
  }
  verCarrito():void{
    const sesionUsuario: SesionUsuario = {
      id: 0,
      lista: this.listaProducto
    }
    this.storeSesion.dispatch(action.sesionUsuario(sesionUsuario));
    this.route.navigateByUrl("carrito");
  }
}
