package provenda.pos.backend.generic.service;

import java.io.Serializable;

import provenda.pos.backend.generic.entity.LifeCycleEntity;
import provenda.pos.backend.security.UserContext;


/**
 * @author Judiao Mbaua
 *
 */
public interface AbstractService<T extends LifeCycleEntity<T>, ID extends Serializable> {

T create(UserContext userContext,T entity);

T update(UserContext userContext,T entity);

void inativate(UserContext userContext,T entity);

void activate(UserContext userContext,T enity);

void delete(UserContext userContext,T enity);

void banish(UserContext userContext,T enity);

}
