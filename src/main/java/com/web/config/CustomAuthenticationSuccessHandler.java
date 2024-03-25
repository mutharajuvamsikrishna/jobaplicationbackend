package com.web.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.web.model.Register;
import com.web.service.UserService;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
@Autowired
    private  UserService userService;



    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        System.out.println("Success");

        Object principal = authentication.getPrincipal();

        if (principal instanceof DefaultOidcUser) {
            DefaultOidcUser oidcUser = (DefaultOidcUser) principal;
            System.out.println(oidcUser);
            Register userEntity = convertOidcUserToUserEntity(oidcUser);
            userService.processOAuthPostLogin(userEntity);
            // Store userEntity in the session
            HttpSession session = request.getSession(true);
            session.setAttribute("userEntity", userEntity);

            // Now you have a UserEntity object that you can use as needed
            System.out.println("in config UserEntity: " + userEntity);

            // Redirect to the desired URL
            // In this example, redirect to "/loginoauth"
            // You can customize this URL as needed
            response.sendRedirect(request.getContextPath() + "/loginoauth");
        } else {
            // Handle other cases or log a warning
            System.out.println("Unexpected principal type: " + principal.getClass());
        }
    }

    private Register convertOidcUserToUserEntity(DefaultOidcUser oidcUser) {
        Register userEntity = new Register();
        userEntity.setEmail(oidcUser.getEmail());
        userEntity.setMob(oidcUser.getPhoneNumber());
        userEntity.setEname(oidcUser.getFullName());
        // Map other attributes as needed
        return userEntity;
    }
}
