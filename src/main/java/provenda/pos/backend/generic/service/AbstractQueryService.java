package provenda.pos.backend.generic.service;

import java.io.Serializable;

import provenda.pos.backend.generic.entity.LifeCyCleState;
import provenda.pos.backend.generic.entity.LifeCycleEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author Judiao Mbaua
 *
 */
public interface AbstractQueryService<T extends LifeCycleEntity<T>, ID extends Serializable> {

Mono<T> findById(ID id);

Flux<T> findAll();

Flux<T> findByActiveAndState(LifeCyCleState lifeCyCleState);


}
