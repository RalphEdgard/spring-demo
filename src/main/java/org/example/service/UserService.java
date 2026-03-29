package org.example.service;

import org.example.component.FieldInjectionComponent;
import org.example.model.UserMetadataModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.repository.UserRepository;

@Service
public class UserService {

    // This is constructor injection
    private final UserRepository userRepository;
    private final FieldInjectionComponent fieldInjectionComponent;

    // This is the constructor whose dependencies were passed to the parameters
    public UserService(UserRepository userRepository, FieldInjectionComponent fieldInjectionComponent) {
        this.userRepository = userRepository;
        this.fieldInjectionComponent = fieldInjectionComponent;
    }

    public String processUser() { return "Processed: " + userRepository.getUserFromDb(); }

    // the program originally had a command line runner that would use the outer method to call the inner method but that would bypass proxy
    // its a separate example from the repository it uses the transactional method to demonstrate the problem
    public void outerMethod() {
        System.out.println("heeheehee");
        innerTransactionalMethod();
    }
    @Transactional
    public UserMetadataModel getMetadataData() {
        return new UserMetadataModel(userRepository.getUserFromDb(), userRepository.getTransactionsFromDb());
    }
    @Transactional
    public void innerTransactionalMethod() {
        System.out.println("Transactional method executed");
        throw new RuntimeException("rolling back forced!");
    }

    public String executedLoggerUtilFieldInjectionServiceLayer() {
        return fieldInjectionComponent.executedLoggerUtilFieldInjection();
    }
}
