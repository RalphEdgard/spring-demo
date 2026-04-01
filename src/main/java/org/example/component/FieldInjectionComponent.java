package org.example.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.example.component.LoggerUtil;


@Component
public class FieldInjectionComponent {
    // this component demonstrates field injection
    // consturctor injection is preferred over field injection and then there is also setter injection but that is the least preferred
    @Autowired
    private LoggerUtil loggerUtil;

    public String executedLoggerUtilFieldInjection() {
        loggerUtil.log("this is a message from the logger...");
        return "you executed field injection component";
    }
}
