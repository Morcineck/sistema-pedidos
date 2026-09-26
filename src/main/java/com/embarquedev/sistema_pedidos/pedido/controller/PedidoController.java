package com.embarquedev.sistema_pedidos.pedido.controller;

import com.embarquedev.sistema_pedidos.pedido.dto.CriarPedidoRequest;
import com.embarquedev.sistema_pedidos.pedido.entity.Pedido;
import com.embarquedev.sistema_pedidos.pedido.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> criar(
            @RequestBody @Valid CriarPedidoRequest request
            ) {

        Pedido pedidoCriado = pedidoService.criar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pedidoCriado);
    }
}
