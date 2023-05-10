package salamancacartelos.proposalsservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import salamancacartelos.proposalsservice.dtos.RootDto;
import salamancacartelos.proposalsservice.dtos.StatusDto;

@RestController
@RequestMapping("/api")
public class RootController {

    @GetMapping("/")
    public ResponseEntity<RootDto> getRoot() {
        RootDto root = new RootDto("proposals-service", "1.0");
        return ResponseEntity.ok(root);
    }

    @GetMapping("/status")
    public ResponseEntity<StatusDto> getStatus() {
        StatusDto statusDto = new StatusDto(true);
        return ResponseEntity.ok(statusDto);
    }

}
