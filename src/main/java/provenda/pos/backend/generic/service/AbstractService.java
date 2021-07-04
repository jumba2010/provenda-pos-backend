package provenda.pos.backend.generic.service;

import java.io.Serializable;

import provenda.pos.backend.security.UserContext;
import reactor.core.publisher.Mono;


/**
 * @author Judiao Mbaua
 *
 */
public interface AbstractService<T, ID extends Serializable> {

Mono<T> create(UserContext userContext,T entity);

Mono<T> update(UserContext userContext,T entity);

void inativate(UserContext userContext,T entity);

void activate(UserContext userContext,T enity);

void delete(UserContext userContext,T enity);

void banish(UserContext userContext,T enity);

}
