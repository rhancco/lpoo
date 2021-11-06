import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { retry, catchError } from 'rxjs/operators';
import { Producto, RespuestaProducto } from "./interfaces";

@Injectable({
    providedIn: 'root'
})
export class ApiService {
    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json;charset=utf-8'
        })
    };
    errorHandl(error: any) {
        let errorMessage = '';
        if (error.error instanceof ErrorEvent) {
            errorMessage = error.error.message;
        } 
        else {
            errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
        }    
        console.log(errorMessage);
        return throwError(errorMessage);
    }
    constructor(private http: HttpClient) { }  
    
    obtenerProductos(data:Producto): Observable<RespuestaProducto> {
        return this.http.post<RespuestaProducto>('http://127.0.0.1:8080/obtener-productos', data, this.httpOptions)
        .pipe(
            retry(1),
            catchError(this.errorHandl)
        );
    }
    

}
