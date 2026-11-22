package com.seuapp.cardapio.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("""
        select p from Produto p
        join fetch p.categoria c
        left join fetch p.tamanhos
        where p.ativo = true and c.ativa = true
        order by c.ordem, p.nome
        """)
    List<Produto> findAtivosParaCardapio();
}