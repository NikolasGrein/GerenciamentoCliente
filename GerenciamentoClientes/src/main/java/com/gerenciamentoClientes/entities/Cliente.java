package com.gerenciamentoClientes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String nome;
	
	@NotNull
	@NotBlank
	@Email (message = "Informe o telefone corretamente")
	private String telefone;
	
	@NotNull
	@NotBlank
	@Email (message = "Informe o cpf corretamente")
	private String cpf;
	
	@NotNull
	@NotBlank
	@Email (message = "Informe o rg corretamente")
	private String rg;
	
	@NotNull
	@NotBlank
	@Email (message = "Informe o endereco corretamente")
	private String endereco;
}
