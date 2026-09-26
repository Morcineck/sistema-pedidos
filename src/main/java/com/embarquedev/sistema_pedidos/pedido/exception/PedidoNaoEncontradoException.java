package com.embarquedev.sistema_pedidos.pedido.exception;

public class PedidoNaoEncontradoException extends RuntimeException {

    public PedidoNaoEncontradoException(Long id) {
        super("Pedido não encontrado: " + id);
    }
}
