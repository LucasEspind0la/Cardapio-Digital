package com.seuapp.cardapio.catalogo;

import com.seuapp.cardapio.categoria.Categoria;
import com.seuapp.cardapio.produto.Produto;
import com.seuapp.cardapio.produto.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CardapioService {

    private final ProdutoRepository produtoRepository;

    public CardapioService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional(readOnly = true)
    public List<CategoriaCardapioDto> montarCardapio() {
        List<Produto> produtos = produtoRepository.findAtivosParaCardapio();

        // LinkedHashMap preserva a ordem da consulta (já ordenada por categoria)
        Map<Categoria, List<ProdutoDto>> porCategoria = new LinkedHashMap<>();
        for (Produto p : produtos) {
            porCategoria
                .computeIfAbsent(p.getCategoria(), c -> new ArrayList<>())
                .add(paraDto(p));
        }

        return porCategoria.entrySet().stream()
            .map(e -> new CategoriaCardapioDto(
                e.getKey().getId(), e.getKey().getNome(), e.getValue()))
            .toList();
    }

    private ProdutoDto paraDto(Produto p) {
        List<TamanhoDto> tamanhos = p.getTamanhos().stream()
            .map(t -> new TamanhoDto(t.getId(), t.getNome(), t.getPreco()))
            .toList();
        return new ProdutoDto(p.getId(), p.getNome(), p.getDescricao(),
                              p.getImagemUrl(), tamanhos);
    }
}