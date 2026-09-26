package com.embarquedev.sistema_pedidos.pedido.service;

import com.embarquedev.sistema_pedidos.pedido.dto.CriarPedidoRequest;
import com.embarquedev.sistema_pedidos.pedido.dto.ItemPedidoRequest;
import com.embarquedev.sistema_pedidos.pedido.entity.ItemPedido;
import com.embarquedev.sistema_pedidos.pedido.entity.Pedido;
import com.embarquedev.sistema_pedidos.pedido.entity.StatusPedido;
import com.embarquedev.sistema_pedidos.pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido criar(CriarPedidoRequest request) {

        List<ItemPedido> itens = request.itens()
                .stream()
                .map(this::converterItem)
                .toList();

        BigDecimal valorTotal = calcularValorTotal(itens);

        Pedido pedido = Pedido.builder()
                .cliente(request.cliente())
                .itens(itens)
                .valorTotal(valorTotal)
                .status(StatusPedido.CRIADO)
                .build();

        return pedidoRepository.save(pedido);

    }

    private ItemPedido converterItem(ItemPedidoRequest itemRequest) {
        return ItemPedido.builder()
                .nome(itemRequest.nome())
                .quantidade(itemRequest.quantidade())
                .valorUnitario(itemRequest.valorUnitario())
                .build();
    }

    private BigDecimal calcularValorTotal(List<ItemPedido> itens) {
        return itens.stream()
                .map(item ->
                        item.getValorUnitario()
                                .multiply(BigDecimal.valueOf(item.getQuantidade()))
                )
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
