package xyz.codingmentor.movie.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.movie.api.CRUDRepository;
import xyz.codingmentor.movie.api.CRUDRepositoryQualifier;
import xyz.codingmentor.movie.api.CRUDService;
import xyz.codingmentor.movie.api.CRUDServiceQualifier;
import xyz.codingmentor.movie.api.Entity;
import xyz.codingmentor.movie.entity.Trailer;

/**
 *
 * @author Ádám
 */
@Stateless
@CRUDServiceQualifier(Entity.TRAILER)
public class TrailerCRUDService extends GenericCRUDService<Trailer> implements CRUDService<Trailer> {
    
    public TrailerCRUDService() {
        super(null);
    }
    
    @Inject
    public TrailerCRUDService(@CRUDRepositoryQualifier(Entity.TRAILER) CRUDRepository<Trailer> repository) {
        super(repository);
    }
}
