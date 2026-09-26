package com.embarquedev.sistema_pedidos.pedido.controller;

import com.embarquedev.sistema_pedidos.pedido.dto.AtualizaStatusResquest;
import com.embarquedev.sistema_pedidos.pedido.dto.CriarPedidoRequest;
import com.embarquedev.sistema_pedidos.pedido.entity.Pedido;
import com.embarquedev.sistema_pedidos.pedido.entity.StatusPedido;
import com.embarquedev.sistema_pedidos.pedido.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Pedido>> listarTodos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.buscarPorId(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Pedido> atualizarStatus(
            @PathVariable Long id,
            @RequestBody @Valid AtualizaStatusResquest request

    ) {

        return ResponseEntity.ok(
                pedidoService.atualizarStatus(id, request));
    }
}
