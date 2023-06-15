package carapuceogang.salamancacartelos.authservice.controllers;

import carapuceogang.salamancacartelos.authservice.dtos.RootDto;
import carapuceogang.salamancacartelos.authservice.dtos.StatusDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RootController {

    @GetMapping
    public ResponseEntity<RootDto> getRoot() {
        RootDto root = new RootDto("auth-service", "1.0");
        return ResponseEntity.ok(root);
    }

    @GetMapping("/status")
    public ResponseEntity<StatusDto> getStatus() {
        StatusDto statusDto = new StatusDto(true);
        return ResponseEntity.ok(statusDto);
    }

}
