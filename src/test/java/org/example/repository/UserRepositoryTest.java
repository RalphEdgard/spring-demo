package org.example.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    @InjectMocks
    private UserRepository userRepository;

    @Test
    void testGetUserFromDb() {
        String result = userRepository.getUserFromDb();
        assertEquals("got data from db", result);
    }
    @Test
    void testGetTransactionsFromDb() {
        String result = userRepository.getTransactionsFromDb();
        assertEquals("got transaction data from db", result);
    }
}
