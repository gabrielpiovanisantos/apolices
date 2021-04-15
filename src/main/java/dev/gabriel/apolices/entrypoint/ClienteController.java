package dev.gabriel.apolices.entrypoint;

import dev.gabriel.apolices.entity.Cliente;
import dev.gabriel.apolices.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody Cliente cliente) {
        clienteService.save(cliente);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}
