import { Component, computed, input, output } from '@angular/core';
import { Produto } from 'shared';

const brl = new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' });

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.html',
  styleUrl: './product-card.scss',
})
export class ProductCard {
  readonly produto = input.required<Produto>();
  readonly escolher = output<Produto>();

  protected readonly precoInicial = computed(() => {
    const precos = this.produto().tamanhos.map((t) => t.preco);
    return precos.length ? Math.min(...precos) : null;
  });

  protected formatar(valor: number): string {
    return brl.format(valor);
  }
}
