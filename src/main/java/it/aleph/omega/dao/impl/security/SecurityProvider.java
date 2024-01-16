package it.aleph.omega.dao.impl.security;

import it.aleph.omega.model.security.UserIdentity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import jakarta.security.enterprise.identitystore.IdentityStore;
import org.mindrot.jbcrypt.BCrypt;

@DatabaseIdentityStoreDefinition
public class SecurityProvider implements IdentityStore {

    @PersistenceContext(unitName = "OmegaLegacy")
    private EntityManager entityManager;


    public CredentialValidationResult.Status validate(UsernamePasswordCredential credential){
        if(BCrypt.checkpw(credential.getPasswordAsString(), retrieveIdentity(credential.getCaller()).getPassword())){
            return CredentialValidationResult.Status.VALID;
        }
        return CredentialValidationResult.Status.INVALID;

    }

    private UserIdentity retrieveIdentity(String callerName){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserIdentity> criteriaQuery = criteriaBuilder.createQuery(UserIdentity.class);
        Root<UserIdentity> userIdentityRoot = criteriaQuery.from(UserIdentity.class);
        Predicate userEqualPredicate = criteriaBuilder.equal(userIdentityRoot.get("username"), callerName);
        criteriaQuery.select(userIdentityRoot).where(userEqualPredicate);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
