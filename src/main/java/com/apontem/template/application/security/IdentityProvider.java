package com.apontem.template.application.security;

import com.apontem.template.application.security.exception.ForbiddenAccess;
import com.apontem.template.application.security.exception.UnAuthorizedAccess;

public interface IdentityProvider {
    Identity getIdentity(String token) throws UnAuthorizedAccess, ForbiddenAccess;
}
