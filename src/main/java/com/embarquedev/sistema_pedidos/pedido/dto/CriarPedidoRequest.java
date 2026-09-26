package com.embarquedev.sistema_pedidos.pedido.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CriarPedidoRequest(

        @NotBlank(message = "O cliente é obrigatório")
        String cliente,

        @NotEmpty(message = "O pedido deve possuir pelo menos um item")
        List<@Valid ItemPedidoRequest> itens

) {

}
