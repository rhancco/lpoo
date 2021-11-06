import {createReducer, on} from '@ngrx/store';
import * as states from './action';
import { SesionUsuario} from './interfaces';

export const initialSesionUsuario:SesionUsuario = {
    id: 0,
    lista: []
};

const _sesionUsuarioReducer = createReducer(
    initialSesionUsuario, 
    on(states.sesionUsuario,(state,{id, lista}) => ( 
            {id: id, lista : lista} )
    )
);
export function sesionUsuarioReducer(state: SesionUsuario, action: any){
    return _sesionUsuarioReducer(state,action);
}
