package com.seuapp.cardapio.catalogo;

import java.util.List;

public record ProdutoDto(Long id, String nome, String descricao,
                         String imagemUrl, List<TamanhoDto> tamanhos) {}