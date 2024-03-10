package br.com.luxauto.luxauto.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class HomeController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/dashboard").setViewName("dashboard");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/login").setViewName("/Login/login");
        registry.addViewController("/ofertas").setViewName("/Ofertas/ofertas");
    }

}