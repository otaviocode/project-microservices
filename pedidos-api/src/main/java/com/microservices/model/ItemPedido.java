package com.microservices.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {

	/* Universally Unique Identifier */
	private UUID id = UUID.randomUUID();
	private Produto produto;
	private Integer quantidade;

	/*
	 * private UUID id Creates a space to store this unique tag.. UUID.randomUUID()
	 * Automatically generates a random and unique number for each new toy (or, in
	 * your case, for each object of your application). This is very useful in
	 * microservices, because it ensures that each information has a unique
	 * identifier, without needing sequential numbers that could cause conflicts
	 * between different services.
	 */

}
