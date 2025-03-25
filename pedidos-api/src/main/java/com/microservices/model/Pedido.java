package com.microservices.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.microservices.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

	private UUID id = UUID.randomUUID();
	private String cliente;
	private List<ItemPedido> itemPedidos = new ArrayList<>();
	private Double valorTotal;
	private String emailNotificacao;

	private Status status;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataHora;

}
