package carapuceogang.salamancacartelos.authservice.services;

import carapuceogang.salamancacartelos.authservice.models.*;
import carapuceogang.salamancacartelos.authservice.repositories.RoleRepository;
import carapuceogang.salamancacartelos.authservice.repositories.UserRepository;
import carapuceogang.salamancacartelos.authservice.security.JwtUtils;
import carapuceogang.salamancacartelos.authservice.security.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    public AuthResponse createAuthResponse(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                username,
                password
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserProfile profile = (UserProfile) authentication.getPrincipal();
        String jwt = jwtUtils.createJwt(profile);

        List<ERole> roles = profile.getAuthorities()
            .stream()
            .map(authority -> ERole.valueOf(authority.getAuthority()))
            .collect(Collectors.toList());

        AuthResponse response = new AuthResponse(
            profile.getId(),
            profile.getUsername(),
            profile.getMail(),
            roles,
            jwt
        );

        return response;
    }

    public AuthResponse signIn(String username, String password) throws Exception {
        if(!userRepository.existsByUsername(username)) {
            throw new Exception("username doesn't exist");
        }

        return this.createAuthResponse(username, password);
    }

    public AuthResponse signUp(String username, String mail, String password) throws Exception {
        if(userRepository.existsByUsername(username)) {
            throw new Exception("username already taken");
        }

        if(userRepository.existsByMail(mail)) {
            throw new Exception("mail address already taken");
        }

        User user = new User(
            username,
            mail,
            passwordEncoder.encode(password)
        );

        Set<Role> roles = new HashSet<Role>();
        Optional<Role> userRole = roleRepository.findByName(ERole.ROLE_USER);

        if(!userRole.isPresent()) {
            throw new Exception("user role error :(");
        }

        roles.add(userRole.get());
        user.setRoles(roles);

        userRepository.save(user);

        return this.createAuthResponse(username, password);
    }
}
