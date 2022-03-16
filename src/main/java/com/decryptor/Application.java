package com.decryptor;

import com.decryptor.config.AppConfig;
import com.decryptor.console.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        try {
            ApplicationContext contex = new AnnotationConfigApplicationContext(AppConfig.class);
            var uiMenu = contex.getBean(UiMenu.class);
            uiMenu.startUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

