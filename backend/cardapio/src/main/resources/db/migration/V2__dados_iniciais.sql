INSERT INTO categoria (nome, ordem) VALUES
    ('Açaís', 1),
    ('Complementos', 2),
    ('Bebidas', 3);

INSERT INTO produto (categoria_id, nome, descricao) VALUES
    (1, 'Açaí Tradicional', 'Açaí batido com banana, na medida certa.'),
    (3, 'Água Mineral', 'Água mineral sem gás.');

INSERT INTO produto_tamanho (produto_id, nome, preco) VALUES
    (1, '300ml', 14.00),
    (1, '500ml', 20.00),
    (2, 'Único', 4.00);