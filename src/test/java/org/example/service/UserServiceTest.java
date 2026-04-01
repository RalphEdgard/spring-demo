package org.example.service;

import org.example.component.FieldInjectionComponent;
import org.example.entity.UserEntity;
import org.example.model.UserMetadataModel;
import org.example.repository.RealUserRepository;
import org.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository; // mocking the dependency

    @Mock
    private RealUserRepository realUserRepository;

    @Mock
    private FieldInjectionComponent fieldInjectionComponent;

    @InjectMocks
    private UserService userService; // from there we start to annotate the object with the inject mocks annotation to then call the method that will be used in the test

    @Test
    void testProcessUser() {
        when(userRepository.getUserFromDb()).thenReturn("Ralph"); // mocking the behavior

        String result = userService.processUser(); // executest the real method inside the service

        assertEquals("Processed: Ralph", result);
    }
    @Test
    void testGetMetadataData() {
        when(userRepository.getUserFromDb()).thenReturn("Ralph");
        when(userRepository.getTransactionsFromDb()).thenReturn("Transaction 1");

        UserMetadataModel result = userService.getMetadataData();

        assertEquals("Ralph", result.getUser());
        assertEquals("Transaction 1", result.getTransactions());
    }
    @Test
    void testInnerTransactionalMethod() {
        assertThrows(RuntimeException.class, () -> {
            userService.innerTransactionalMethod();
        });
    }
    @Test
    void testGetActualData(){
        UserEntity userEntity = new UserEntity();
        userEntity.setName("Ralph");
        userEntity.setTranaction("Transaction 1");

        List<UserEntity> mockList = List.of(userEntity);

        when(realUserRepository.findAll()).thenReturn(mockList);

        UserMetadataModel userMetadataModel = userService.getActualData(0);

        assertEquals("Ralph", userMetadataModel.getUser());
        assertEquals("Transaction 1", userMetadataModel.getTransactions());
    }
    @Test
    void testExecutedLoggerUtilFieldInjectionServiceLayer() {
        when(fieldInjectionComponent.executedLoggerUtilFieldInjection()).thenReturn("");
        String result = userService.executedLoggerUtilFieldInjectionServiceLayer();
        assertEquals("", result);
    }
    @Test
    void testOuterMethod() {
        assertThrows(RuntimeException.class, () -> {
            userService.outerMethod();
        });
    }
}
