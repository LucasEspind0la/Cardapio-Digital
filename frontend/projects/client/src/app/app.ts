import { Component } from '@angular/core';
import { CardapioPage } from './cardapio/cardapio-page';

@Component({
  selector: 'app-root',
  imports: [CardapioPage],
  template: `
    <header class="topo">
      <div class="container">
        <span class="logo" aria-hidden="true">🍇</span>
        <h1>Nome da Açaiteria</h1>
      </div>
    </header>
    <main class="container">
      <app-cardapio-page />
    </main>
  `,
})
export class App {}
