package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoggingAspectTest {

    @InjectMocks
    private LoggingAspect loggingAspect;

    @Mock
    private JoinPoint joinPoint;

    @Mock
    private org.aspectj.lang.Signature signature;

    @Test
    void testLogBefore() {
        when(joinPoint.getSignature()).thenReturn(signature);
        when(signature.getName()).thenReturn("testing");

        loggingAspect.logBefore(joinPoint);
    }

    @Test
    void testLogAfter() {
        when(joinPoint.getSignature()).thenReturn(signature);
        when(signature.getName()).thenReturn("testing");

        loggingAspect.logAfter(joinPoint);
    }
}
