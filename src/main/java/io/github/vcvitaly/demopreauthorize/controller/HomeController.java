package io.github.vcvitaly.demopreauthorize.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('Administrator')")
    public String admin(@AuthenticationPrincipal OidcUser user) {
        return "Hello, Admin!<br/><br/><img src=" + user.getPicture() + " width=200/>";
    }

    @GetMapping("/profile")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    public Map<String, Object> profile(OAuth2AuthenticationToken authentication) {
        return authentication.getPrincipal().getAttributes();
    }
}
