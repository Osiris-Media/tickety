package com.osiris.tickety.infra.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Created By francislagueu on 7/3/24
 */
public class TimeExecutionInterceptor implements HandlerInterceptor {
    private static final String TIME = "StopWatch";

    @Override
    public boolean preHandle(
            final HttpServletRequest request,
            @NonNull final HttpServletResponse response,
            @NonNull final Object handler) {
        final long nano = System.nanoTime();

        request.setAttribute(TIME, nano);
        return true;
    }
}
