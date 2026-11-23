import { Component, inject } from '@angular/core';
import { toSignal } from '@angular/core/rxjs-interop';
import { CardapioApi } from 'shared';

@Component({
  selector: 'app-root',
  template: `
    <h1>Cardápio</h1>
    @for (categoria of cardapio(); track categoria.id) {
      <section>
        <h2>{{ categoria.nome }}</h2>
        @for (produto of categoria.produtos; track produto.id) {
          <article>
            <h3>{{ produto.nome }}</h3>
            <p>{{ produto.descricao }}</p>
            @for (t of produto.tamanhos; track t.id) {
              <span>{{ t.nome }}: R$ {{ t.preco }} </span>
            }
          </article>
        }
      </section>
    }
  `,
})
export class App {
  private readonly api = inject(CardapioApi);
  protected readonly cardapio = toSignal(this.api.buscarCardapio(), { initialValue: [] });
}