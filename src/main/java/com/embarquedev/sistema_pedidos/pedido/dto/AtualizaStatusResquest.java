package com.embarquedev.sistema_pedidos.pedido.dto;

import com.embarquedev.sistema_pedidos.pedido.entity.StatusPedido;
import jakarta.validation.constraints.NotNull;

public record AtualizaStatusResquest(

        @NotNull(message = "O status é obrigatório")
        StatusPedido status
) {
}
