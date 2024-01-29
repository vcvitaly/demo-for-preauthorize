package io.github.vcvitaly.demopreauthorize.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping(("/test"))
@Slf4j
public class TestController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getTest(@AuthenticationPrincipal OidcUser user) {
        log.info("Processed a request to getTest");
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toSet());

        return "Hello, " + user.getFullName() + "!<br/><br/>Authorities: " + authorities;
    }

    @GetMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    public String getAdmin(@AuthenticationPrincipal OidcUser user) {
        log.info("Processed a request to getAdmin");
        return "This is the admin's page";
    }
}
