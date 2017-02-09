package xyz.codingmentor.movie.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.movie.api.CRUDRepository;
import xyz.codingmentor.movie.api.CRUDRepositoryQualifier;
import xyz.codingmentor.movie.api.CRUDService;
import xyz.codingmentor.movie.api.CRUDServiceQualifier;
import xyz.codingmentor.movie.api.Entity;
import xyz.codingmentor.movie.entity.Thespian;

/**
 *
 * @author Ádám
 */
@Stateless
@CRUDServiceQualifier(Entity.THESPIAN)
public class ThespianCRUDService extends GenericCRUDService<Thespian> implements CRUDService<Thespian> {

    public ThespianCRUDService() {
        super(null);
    }

    @Inject
    public ThespianCRUDService(@CRUDRepositoryQualifier(Entity.THESPIAN) CRUDRepository<Thespian> repository) {
        super(repository);
    }
}
