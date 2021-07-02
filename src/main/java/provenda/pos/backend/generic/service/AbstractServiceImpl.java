package provenda.pos.backend.generic.service;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import provenda.pos.backend.generic.dao.AbstractBaseRepository;
import provenda.pos.backend.generic.entity.LifeCyCleState;
import provenda.pos.backend.generic.entity.LifeCycleEntity;
import provenda.pos.backend.security.UserContext;

/**
 * @author Judiao Mbaua
 *
 *         <p>
 *         Implementation of the generic repository
 *         </p>
 */
@Service
@Transactional
public class AbstractServiceImpl<T extends LifeCycleEntity<T>, ID extends Serializable>
		implements AbstractService<T, ID> {

	@Autowired
	private AbstractBaseRepository<T, ID> repository;

	@Override
	public T create(UserContext userContext, T entity) {
		entity.setCreatedBy(userContext.getId());
		entity.setActivatedBy(userContext.getId());
		entity.setActive(LifeCyCleState.ACTIVE.isActive());
		entity.setState(LifeCyCleState.ACTIVE.getState());
		return repository.save(entity);
	}

	@Override
	public T update(UserContext userContext, T entity) {
		entity.setUpdatedBy(userContext.getId());
		entity.setUpdatedAt(LocalDateTime.now());
		return repository.save(entity);
	}

	@Override
	public void inativate(UserContext userContext, T entity) {
		entity.setActivatedBy(userContext.getId());
		entity.setActive(LifeCyCleState.INACTIVE.isActive());
		entity.setState(LifeCyCleState.INACTIVE.getState());
		repository.save(entity);

	}

	@Override
	public void activate(UserContext userContext, T entity) {
		entity.setActivatedBy(userContext.getId());
		entity.setActive(LifeCyCleState.ACTIVE.isActive());
		entity.setState(LifeCyCleState.ACTIVE.getState());
		repository.save(entity);

	}

	@Override
	public void delete(UserContext userContext, T entity) {
		entity.setActivatedBy(userContext.getId());
		entity.setActive(LifeCyCleState.DELETED.isActive());
		entity.setState(LifeCyCleState.DELETED.getState());
		repository.save(entity);

	}

	@Override
	public void banish(UserContext userContext, T entity) {
		entity.setActivatedBy(userContext.getId());
		entity.setActive(LifeCyCleState.BANNED.isActive());
		entity.setState(LifeCyCleState.BANNED.getState());
		repository.save(entity);

	}

}
