export interface Marca {
    id?: number;
    nombre?: string;
}
export interface Producto {
    id?: number;
    marca: Marca;
    nombre?: string;
    peso?: number;
    precioRegular?: number;
    precioOferta?: number;
    oferta?: boolean;
    calificacion?: number;
    urlImagen?: string;
}
export interface RespuestaProducto {
    lista: Producto[];
}
export interface SesionUsuario{
    id: number;
    lista?: Producto[];
}