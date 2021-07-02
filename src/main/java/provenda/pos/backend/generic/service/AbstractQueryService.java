package provenda.pos.backend.generic.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

import provenda.pos.backend.generic.entity.LifeCyCleState;
import provenda.pos.backend.generic.entity.LifeCycleEntity;


/**
 * @author Judiao Mbaua
 *
 */
public interface AbstractQueryService<T extends LifeCycleEntity<T>, ID extends Serializable> {

Optional<T> findById(ID id);

Collection<T> findAll();

Collection<T> findByActiveAndState(LifeCyCleState lifeCyCleState);


}
