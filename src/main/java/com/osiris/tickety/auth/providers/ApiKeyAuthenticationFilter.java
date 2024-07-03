package com.osiris.tickety.auth.providers;

import com.osiris.tickety.constants.AppHeaders;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import java.io.IOException;
import java.util.Optional;

/**
 * Created By francislagueu on 7/3/24
 */
@Slf4j
public class ApiKeyAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    public ApiKeyAuthenticationFilter(
            final String defaultFilterProcessesUrl, final AuthenticationManager authenticationManager) {
        super(defaultFilterProcessesUrl);
        this.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(
            final HttpServletRequest request, final HttpServletResponse response) {

        final String apiKeyHeader = request.getHeader(AppHeaders.API_KEY_HEADER);

        final Optional<String> apiKeyOptional =
                StringUtils.isNotBlank(apiKeyHeader) ? Optional.of(apiKeyHeader) : Optional.empty();

        log.debug("found header value '{}'", apiKeyOptional);

        final ApiKeyAuthentication apiKey =
                apiKeyOptional.map(ApiKeyAuthentication::new).orElse(new ApiKeyAuthentication());

        return this.getAuthenticationManager().authenticate(apiKey);
    }

    @Override
    protected void successfulAuthentication(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final FilterChain chain,
            final Authentication authResult)
            throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
    }
}
