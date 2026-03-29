package org.example.component;

import org.springframework.stereotype.Component;

// This is to demonstrate the component generic type
@Component
public class LoggerUtil {
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
