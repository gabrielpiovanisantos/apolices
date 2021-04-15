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
    public ResponseEntity<HttpStatus> save(@RequestBody Apolice apolice) {
        apoliceService.save(apolice);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{numero}")
    public ApoliceBO getByNumber(@PathVariable Integer numero){
        return apoliceService.getByNumber(numero);
    }

}
