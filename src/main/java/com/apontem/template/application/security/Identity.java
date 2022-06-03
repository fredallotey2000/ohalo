package com.apontem.template.application.security;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
public class Identity {
    @Setter(AccessLevel.PROTECTED)
    private String userId;
    @Setter(AccessLevel.PROTECTED)
    private Name name;
    @Setter(AccessLevel.PROTECTED)
    private Contact contact;
    @Setter(AccessLevel.PROTECTED)
    private Credential credential;
    @Setter(AccessLevel.PROTECTED)
    private List<Account> accounts;
    @Setter(AccessLevel.PROTECTED)
    private String status;
    @Setter(AccessLevel.PROTECTED)
    private boolean verified;

    @Getter
    @NoArgsConstructor
    public static class Name {
        private String firstName;
        private String lastName;
        @Setter(AccessLevel.PROTECTED)
        private String middleName;

        Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
    @Getter
    @NoArgsConstructor
    public static class Contact {
        private String email;
        private String mobilePhoneNumber;

        Contact(String email, String mobilePhoneNumber) {
            this.email = email;
            this.mobilePhoneNumber = mobilePhoneNumber;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class Credential {
        private String loginId;
        private String password;

        Credential(String loginId, String password) {
            this.loginId = loginId;
            this.password = password;
        }
    }

    @Getter
    public static class Account {
        private String accountNumber;
        private String accountType;
    }
}
