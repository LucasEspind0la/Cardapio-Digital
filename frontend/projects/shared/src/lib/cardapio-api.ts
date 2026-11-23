import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CategoriaCardapio } from './cardapio.models';

@Injectable({ providedIn: 'root' })
export class CardapioApi {
  private readonly http = inject(HttpClient);

  buscarCardapio(): Observable<CategoriaCardapio[]> {
    return this.http.get<CategoriaCardapio[]>('/api/public/cardapio');
  }
}