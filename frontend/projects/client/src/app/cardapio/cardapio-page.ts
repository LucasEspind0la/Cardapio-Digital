import { Component, computed, inject, signal } from '@angular/core';
import { toSignal } from '@angular/core/rxjs-interop';
import { CardapioApi, Produto } from 'shared';
import { ProductCard } from './product-card';

@Component({
  selector: 'app-cardapio-page',
  imports: [ProductCard],
  templateUrl: './cardapio-page.html',
  styleUrl: './cardapio-page.scss',
})
export class CardapioPage {
  private readonly api = inject(CardapioApi);

  protected readonly cardapio = toSignal(this.api.buscarCardapio(), { initialValue: [] });

  private readonly idEscolhido = signal<number | null>(null);

  protected readonly categoriaAtiva = computed(() => {
    const lista = this.cardapio();
    return lista.find((c) => c.id === this.idEscolhido()) ?? lista[0] ?? null;
  });

  protected selecionarCategoria(id: number): void {
    this.idEscolhido.set(id);
  }

  protected escolher(produto: Produto): void {
    console.log('Produto escolhido:', produto.nome);
  }
}
