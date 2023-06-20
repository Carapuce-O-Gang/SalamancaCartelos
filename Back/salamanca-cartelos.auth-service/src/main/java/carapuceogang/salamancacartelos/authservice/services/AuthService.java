package carapuceogang.salamancacartelos.authservice.services;

import carapuceogang.salamancacartelos.authservice.dtos.AuthDto;
import carapuceogang.salamancacartelos.authservice.dtos.SignInDto;
import carapuceogang.salamancacartelos.authservice.dtos.SignUpDto;
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

    public AuthDto createAuthResponse(String username, String password) {
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

        return new AuthDto(
            profile.getId(),
            profile.getUsername(),
            profile.getMail(),
            roles,
            jwt
        );
    }

    public AuthDto signIn(SignInDto signInDto) throws Exception {
        if(!userRepository.existsByUsername(signInDto.getUsername())) {
            throw new Exception("username doesn't exist");
        }

        return this.createAuthResponse(
            signInDto.getUsername(),
            signInDto.getPassword()
        );
    }

    public AuthDto signUp(SignUpDto signUpDto) throws Exception {
        if(userRepository.existsByUsername(signUpDto.getUsername())) {
            throw new Exception("username already taken");
        }

        if(userRepository.existsByMail(signUpDto.getMail())) {
            throw new Exception("mail address already taken");
        }

        User user = new User(
            signUpDto.getUsername(),
            signUpDto.getMail(),
            passwordEncoder.encode(signUpDto.getPassword())
        );

        Set<Role> roles = new HashSet<Role>();
        Optional<Role> userRole = roleRepository.findByName(ERole.USER);

        if(userRole.isEmpty()) {
            throw new Exception("user role error :(");
        }

        roles.add(userRole.get());
        user.setRoles(roles);

        userRepository.save(user);

        return this.createAuthResponse(
            signUpDto.getUsername(),
            signUpDto.getPassword()
        );
    }

    public void signOut() {
        // to do ...
    }
}
