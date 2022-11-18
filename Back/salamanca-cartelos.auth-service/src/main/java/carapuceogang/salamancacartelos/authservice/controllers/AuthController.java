package carapuceogang.salamancacartelos.authservice.controllers;

import carapuceogang.salamancacartelos.authservice.dtos.SignInDto;
import carapuceogang.salamancacartelos.authservice.dtos.SignUpDto;
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
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDto signUpDto) throws Exception {
        return ResponseEntity.ok(authService.signUp(signUpDto));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignInDto signInDto) throws Exception {
        return ResponseEntity.ok(authService.signIn(signInDto));
    }

    @GetMapping("/sign-out")
    public void signOut() {
        authService.signOut();
    }
}
