package io.github.vcvitaly.demopreauthorize.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/test"))
@Slf4j
public class TestController {

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String getHello(@AuthenticationPrincipal OidcUser user) {
        log.info("Processed a request to getHello");
        return "Hello world!";
    }

    @GetMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    public String getAdmin(@AuthenticationPrincipal OidcUser user) {
        log.info("Processed a request to getAdmin");
        return "This is the admin's page";
    }
}
