package com.gerenciamentoClientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamentoClientes.entities.Cliente;
import com.gerenciamentoClientes.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Clientes", description = "API REST DE GERENCIAMENTO DE CLIENTES")
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	private final ClienteService clienteService;
	
	@Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
	
	@GetMapping("/{id}")
	@Operation(summary = "Localiza cliente por ID")
    public ResponseEntity<Cliente> buscaClienteControlId(@PathVariable Long id) {
		Cliente cliente = clienteService.buscaClienteId(id); 
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
        
    @GetMapping("/")
    @Operation(summary = "Apresenta todos os clientes")
    public ResponseEntity<List<Cliente>> buscaTodosClienteControl() { 
        List<Cliente> cliente = clienteService.buscaTodosClientes();
        return ResponseEntity.ok(cliente);
    }
        
    @PostMapping("/")
    public ResponseEntity<Cliente> salvaClienteControl(@RequestBody Cliente cliente) { 
        Cliente salvaCliente = clienteService.salvaCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaCliente);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Altera um cliente")
    public ResponseEntity<Cliente> alteraClienteControl(@PathVariable Long id, @RequestBody Cliente cliente) { 
        Cliente alteraCliente = clienteService.alterarCliente(id, cliente);
        if (alteraCliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um cliente")
    public ResponseEntity<String> apagaClienteControl(@PathVariable Long id) { 
        boolean apagar = clienteService.apagarCliente(id);
        if (apagar) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
