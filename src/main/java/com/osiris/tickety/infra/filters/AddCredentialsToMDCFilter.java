package com.osiris.tickety.infra.filters;

import com.osiris.tickety.facades.AuthFacade;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * This filter is used to inject user and company value
 * within MDC context.
 * Created By francislagueu on 7/3/24
 */
@Component
public class AddCredentialsToMDCFilter extends OncePerRequestFilter {
    private static final String USER_MDC_KEY = "user";
    private static final String COMPANY_MDC_KEY = "company";

    @Override
    protected void doFilterInternal(
            final @NonNull HttpServletRequest request,
            final @NonNull HttpServletResponse response,
            final FilterChain filterChain)
            throws ServletException, IOException {

        MDC.put(USER_MDC_KEY, AuthFacade.getUserEmail());
        MDC.put(COMPANY_MDC_KEY, AuthFacade.getCompanySlug());

        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(USER_MDC_KEY);
            MDC.remove(COMPANY_MDC_KEY);
        }
    }

    @Override
    protected boolean shouldNotFilterAsyncDispatch() {
        return false;
    }

    @Override
    protected boolean shouldNotFilterErrorDispatch() {
        return false;
    }
}
