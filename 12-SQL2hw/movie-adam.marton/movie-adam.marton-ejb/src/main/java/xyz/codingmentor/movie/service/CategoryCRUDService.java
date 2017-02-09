package xyz.codingmentor.movie.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.movie.api.CRUDRepository;
import xyz.codingmentor.movie.api.CRUDRepositoryQualifier;
import xyz.codingmentor.movie.api.CRUDService;
import xyz.codingmentor.movie.api.CRUDServiceQualifier;
import xyz.codingmentor.movie.api.Entity;
import xyz.codingmentor.movie.entity.Category;

/**
 *
 * @author Ádám
 */
@Stateless
@CRUDServiceQualifier(Entity.CATEGORY)
public class CategoryCRUDService extends GenericCRUDService<Category> implements CRUDService<Category> {
    
    public CategoryCRUDService() {
        super(null);
    }
    
    @Inject
    public CategoryCRUDService(@CRUDRepositoryQualifier(Entity.CATEGORY) CRUDRepository<Category> repository) {
        super(repository);
    }
}
