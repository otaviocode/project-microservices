package com.microservices.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

	/* Every time I created a object product it'll generate a random id */
	private UUID id = UUID.randomUUID();
	private Double valor;
	private String nomeProduto;

}
