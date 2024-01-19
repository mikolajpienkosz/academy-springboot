package com.accenture.academy.cookieandheader;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
@RequiredArgsConstructor
class CookieRestController {
    private final CookieService cookieService;

    @GetMapping("/ciacho")
    ResponseEntity<?> getCiacho(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null){
            ipAddress = request.getRemoteAddr();
            log.info(ipAddress);
        }


        cookieService.consumeWithCookie(ipAddress);

        return ResponseEntity
                .status(200)
                .header("super secret stuff", ipAddress)
                .body("bonjour");
    }

}
