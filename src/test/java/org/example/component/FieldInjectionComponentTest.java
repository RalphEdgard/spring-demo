package org.example.component;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FieldInjectionComponentTest {

    @Mock
    private LoggerUtil loggerUtil;

    @InjectMocks
    private FieldInjectionComponent fieldInjectionComponent;

    @Test
    void testExecutedLoggerUtilFieldInjection() {
        String result = fieldInjectionComponent.executedLoggerUtilFieldInjection();

        assertEquals("you executed field injection component", result);

        verify(loggerUtil).log("this is a message from the logger...");
    }
}
