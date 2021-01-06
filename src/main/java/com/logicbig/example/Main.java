package com.logicbig.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@ComponentScan("com.logicbig.example")
@SpringBootApplication
public class Main{

    public static void main (String[] args) {
        SpringApplication.run(Main.class, args);
    }
    
    @PostConstruct
    public void init() {
    	ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "MY_launchVSCODE.bat");
        File dir = new File("E:/ANGULAR_POC_DEMO/PortableVSCODE/VSCode-win32-x64-1.51.1");
        pb.directory(dir);
        try {
			Process p = pb.start();
		} catch (IOException e) {
			System.out.println("Getting exception while running batch file..."+e.getMessage());
		}
    }

    @Bean
    ServletRegistrationBean jsfServletRegistration (ServletContext servletContext) {
        //spring boot only works if this is set
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

        //FacesServlet registration
        ServletRegistrationBean srb = new ServletRegistrationBean();
        srb.setServlet(new FacesServlet());
        srb.setUrlMappings(Arrays.asList("*.xhtml"));
        srb.setLoadOnStartup(1);
        return srb;
    }
}