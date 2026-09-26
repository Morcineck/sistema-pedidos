package com.embarquedev.sistema_pedidos.pedido.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ItemPedidoRequest(

        @NotBlank(message = "O nome do item é obrigatório")
        String nome,

        @NotNull(message = "A quantidade é obrigatória")
        @Min(value = 1, message = "A quantidade deve ser maior que zero")
        Integer quantidade,

        @NotNull(message = "O valor unitário é obrigatório")
        @DecimalMin(value = "0.01", message = "O valor unitário deve ser maior que zero")
        BigDecimal valorUnitario
) {
}
