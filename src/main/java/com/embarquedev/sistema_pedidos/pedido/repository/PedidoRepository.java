package com.embarquedev.sistema_pedidos.pedido.repository;

import com.embarquedev.sistema_pedidos.pedido.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
