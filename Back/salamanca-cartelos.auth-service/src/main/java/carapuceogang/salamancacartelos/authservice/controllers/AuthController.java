package carapuceogang.salamancacartelos.authservice.controllers;

import carapuceogang.salamancacartelos.authservice.models.*;
import carapuceogang.salamancacartelos.authservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest signUp) throws Exception {
        return ResponseEntity.ok(authService.signUp(
            signUp.getUsername(),
            signUp.getMail(),
            signUp.getPassword()
        ));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignInRequest signIn) throws Exception {
        return ResponseEntity.ok(authService.signIn(
                signIn.getUsername(),
                signIn.getPassword()
        ));
    }

    //@GetMapping("/sign-out")
    public void signOut() {
        // to implement ...
    }
}
