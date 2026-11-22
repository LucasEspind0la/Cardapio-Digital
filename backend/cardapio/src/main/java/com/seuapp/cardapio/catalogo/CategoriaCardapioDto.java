package com.seuapp.cardapio.catalogo;

import java.util.List;

public record CategoriaCardapioDto(Long id, String nome, List<ProdutoDto> produtos) {}