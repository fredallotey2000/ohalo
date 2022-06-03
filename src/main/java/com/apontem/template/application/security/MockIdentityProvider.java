package com.apontem.template.application.security;

public class MockIdentityProvider implements IdentityProvider{
    @Override
    public Identity getIdentity(String token) {
        Identity identity = new Identity();
        identity.setName(new Identity.Name("James", "Green"));
        identity.setContact(new Identity.Contact("jamesgreen@yahoo.com", "+233217863452"));
        identity.setCredential(new Identity.Credential("jamesgreen@yahoo.com", "123456"));
        return new Identity();
    }
}
