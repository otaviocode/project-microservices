package com.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.Pedido;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pedidos", description = "Recurso para criar um novo pedido!")
@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

	private final Logger logger = LoggerFactory.getLogger(PedidoController.class);

	@PostMapping
	@Operation(summary = "Criar um Novo pedido!", 
	description = "Contem as operações para criar um novo pedido", 
	responses = @ApiResponse(responseCode = "201", 
	description = "Recurso criado com sucesso!", 
	content = @Content(mediaType = "application/json", 
	schema = @Schema(implementation = Pedido.class))))
	public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {

		logger.info("Pedido Recebido! {}", pedido.toString());

		return ResponseEntity.status(HttpStatus.CREATED).body(pedido);

	}
}
