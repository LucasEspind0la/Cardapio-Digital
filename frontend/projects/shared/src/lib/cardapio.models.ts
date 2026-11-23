export interface Tamanho {
  id: number;
  nome: string;
  preco: number;
}

export interface Produto {
  id: number;
  nome: string;
  descricao: string | null;
  imagemUrl: string | null;
  tamanhos: Tamanho[];
}

export interface CategoriaCardapio {
  id: number;
  nome: string;
  produtos: Produto[];
}