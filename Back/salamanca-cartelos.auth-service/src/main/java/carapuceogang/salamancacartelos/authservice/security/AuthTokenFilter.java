package carapuceogang.salamancacartelos.authservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import carapuceogang.salamancacartelos.authservice.security.JwtUtils;

public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException
    {
        try {
            String token = jwtUtils.getJwt(request);

            if (token != null && jwtUtils.validateJwt(token)) {
                String username = jwtUtils.getUsernameFromJwt(token);
                UserDetails userDetails = userProfileService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                WebAuthenticationDetailsSource detailsSource = new WebAuthenticationDetailsSource();
                authentication.setDetails(detailsSource.buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } finally {
            filterChain.doFilter(request, response);
        }
    }
}
