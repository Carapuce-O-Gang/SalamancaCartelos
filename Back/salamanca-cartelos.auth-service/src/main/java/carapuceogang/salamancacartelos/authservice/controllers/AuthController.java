package carapuceogang.salamancacartelos.authservice.controllers;

import carapuceogang.salamancacartelos.authservice.models.*;
import carapuceogang.salamancacartelos.authservice.repositories.RoleRepository;
import carapuceogang.salamancacartelos.authservice.repositories.UserRepository;
import carapuceogang.salamancacartelos.authservice.security.JwtUtils;
import carapuceogang.salamancacartelos.authservice.security.UserProfile;
import carapuceogang.salamancacartelos.authservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest signUp) {
        try {
            return ResponseEntity.ok(authService.signUp(
                signUp.getUsername(),
                signUp.getMail(),
                signUp.getPassword()
            ));
        }

        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignInRequest signIn) {
        try {
            return ResponseEntity.ok(authService.signIn(
                    signIn.getUsername(),
                    signIn.getPassword()
            ));
        }

        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //@GetMapping("/sign-out")
    public void signOut() {
        // to implement ...
    }
}
