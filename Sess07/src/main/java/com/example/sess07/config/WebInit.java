package com.example.sess07.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //code bai 3
//    @Override
//    protected void customizeRegistration(jakarta.servlet.ServletRegistration.Dynamic registration) {
//
//        jakarta.servlet.MultipartConfigElement multipartConfig =
//                new jakarta.servlet.MultipartConfigElement(
//                        "C:/RikkeiFood_Temp/",
//                        5 * 1024 * 1024,
//                        10 * 1024 * 1024,
//                        0
//                );
//
//        registration.setMultipartConfig(multipartConfig);
//    }

    //code bai 4
//    @Override
//    protected void customizeRegistration(jakarta.servlet.ServletRegistration.Dynamic registration) {
//
//        jakarta.servlet.MultipartConfigElement multipartConfig =
//                new jakarta.servlet.MultipartConfigElement(
//                        "C:/RikkeiFood_Temp/",
//                        2 * 1024 * 1024,
//                        2 * 1024 * 1024,
//                        0
//                );
//
//        registration.setMultipartConfig(multipartConfig);
//    }

    //code bai 5
    @Override
    protected void customizeRegistration(jakarta.servlet.ServletRegistration.Dynamic registration) {

        jakarta.servlet.MultipartConfigElement multipartConfig =
                new jakarta.servlet.MultipartConfigElement(
                        "C:/RikkeiFood_Temp/",
                        10 * 1024 * 1024,
                        15 * 1024 * 1024,
                        0
                );

        registration.setMultipartConfig(multipartConfig);
    }
}