package com.example.sp_lab5.uvt.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Instant;

@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String path = request.getMethod() + " " + request.getRequestURI();
        long start = System.currentTimeMillis();
        // before
        logger.info("[REQUEST-START] " + path + " at " + Instant.now());

        filterChain.doFilter(request, response);

        // after
        long duration = System.currentTimeMillis() - start;
        logger.info("[REQUEST-END] " + path + " status=" + response.getStatus() +
                " durationMs=" + duration + " at " + Instant.now());
    }
}
