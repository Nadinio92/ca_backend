package org.home;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().headers().frameOptions().disable();
    }

    @Bean
    public HttpFirewall configureFirewall() {
        return new DefaultHttpFirewall();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        var cfg = new CorsConfiguration();
        cfg.addAllowedHeader("*");
        cfg.addAllowedMethod(HttpMethod.GET);
        cfg.addAllowedMethod(HttpMethod.POST);
        cfg.addAllowedMethod(HttpMethod.PUT);
        cfg.addAllowedMethod(HttpMethod.DELETE);
        cfg.addAllowedOrigin("*");
        source.registerCorsConfiguration("/**", cfg);
        return source;
    }

}
