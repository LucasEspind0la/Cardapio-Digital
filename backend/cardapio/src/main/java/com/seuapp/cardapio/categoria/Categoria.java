package com.seuapp.cardapio.categoria;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 80)
    private String nome;

    @Column(nullable = false)
    private int ordem;

    @Column(nullable = false)
    private boolean ativa = true;

    protected Categoria() {
        // exigido pelo JPA; protected impede uso acidental no código da aplicação
    }

    public Categoria(String nome, int ordem) {
        this.nome = nome;
        this.ordem = ordem;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getOrdem() { return ordem; }
    public void setOrdem(int ordem) { this.ordem = ordem; }
    public boolean isAtiva() { return ativa; }
    public void setAtiva(boolean ativa) { this.ativa = ativa; }
}