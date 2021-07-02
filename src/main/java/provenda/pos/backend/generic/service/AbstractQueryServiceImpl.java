package provenda.pos.backend.generic.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import provenda.pos.backend.generic.dao.AbstractBaseRepository;
import provenda.pos.backend.generic.entity.LifeCyCleState;
import provenda.pos.backend.generic.entity.LifeCycleEntity;

@Service
@Transactional
public class AbstractQueryServiceImpl<T extends LifeCycleEntity<T>, ID extends Serializable>
		implements AbstractQueryService<T, ID> {
	
	@Autowired
	private AbstractBaseRepository<T, ID> repository;
	
	@Override
	public Optional<T> findById(ID id) {
		
		return repository.findById(id);
	}

	@Override
	public Collection<T> findAll() {
		return repository.findAll();
	}

	@Override
	public Collection<T> findByActiveAndState(LifeCyCleState lifeCyCleState) {
	
		return repository.findByActiveAndState(lifeCyCleState.isActive(),lifeCyCleState.getState());
	}

}
