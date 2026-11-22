package com.seuapp.cardapio.produto;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto_tamanho")
public class ProdutoTamanho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(nullable = false, length = 40)
    private String nome;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    protected ProdutoTamanho() {
    }

    public ProdutoTamanho(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() { return id; }
    public Produto getProduto() { return produto; }
    void setProduto(Produto produto) { this.produto = produto; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
}