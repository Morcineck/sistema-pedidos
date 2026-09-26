package com.embarquedev.sistema_pedidos.pedido.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> tratarPedidoNaoEncontrado(
            PedidoNaoEncontradoException exception
    ) {

        return ResponseEntity
                 .status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensagem", exception.getMessage()));
    }
}
