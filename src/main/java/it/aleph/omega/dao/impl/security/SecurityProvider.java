package it.aleph.omega.dao.impl.security;

import it.aleph.omega.model.security.UserIdentity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import jakarta.security.enterprise.identitystore.IdentityStore;
import org.mindrot.jbcrypt.BCrypt;

import java.util.HashSet;
import java.util.Set;

@DatabaseIdentityStoreDefinition(
        useFor = {
        IdentityStore.ValidationType.VALIDATE,
        IdentityStore.ValidationType.PROVIDE_GROUPS
},
        callerQuery = "SELECT password FROM user_identity WHERE name= ?",
        groupsQuery = "SELECT group_identity.name " +
        "FROM user_identity " +
        "INNER JOIN group_identity " +
        "WHERE user_identity.group = group_identity.id " +
        "WHERE user_identity.username = ?"
)
public class SecurityProvider implements IdentityStore {
}
