package ru.kpfu.itis.NeilAlishev.sem1.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.sendRedirect("/403");
    }
}


