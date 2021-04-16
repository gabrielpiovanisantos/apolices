package dev.gabriel.apolices.entrypoint;

import dev.gabriel.apolices.entity.Apolice;
import dev.gabriel.apolices.service.ApoliceBO;
import dev.gabriel.apolices.service.ApoliceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apolices")
public class ApoliceController {

    private final ApoliceService apoliceService;

    public ApoliceController(ApoliceService apoliceService) {
        this.apoliceService = apoliceService;
    }

    @PostMapping
    public ResponseEntity<Apolice> save(@RequestBody Apolice apolice) {
        return ResponseEntity.status(HttpStatus.CREATED).body(apoliceService.save(apolice));
    }

    @GetMapping("/{numero}")
    public ResponseEntity<ApoliceBO> getByNumber(@PathVariable Integer numero) {
        ApoliceBO apoliceBO = apoliceService.getByNumber(numero);
        return ResponseEntity.status(HttpStatus.OK).body(apoliceBO);
    }

}
