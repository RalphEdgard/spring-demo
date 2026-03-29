package org.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UserMetadataModel {
    private String user;
    private String transactions;

    public UserMetadataModel(String user, String transactions) {
        this.user = user;
        this.transactions = transactions;
    }

}
