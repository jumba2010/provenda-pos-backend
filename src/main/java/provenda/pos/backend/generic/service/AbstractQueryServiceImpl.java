package provenda.pos.backend.generic.service;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import provenda.pos.backend.generic.dao.AbstractBaseRepository;
import provenda.pos.backend.generic.entity.LifeCyCleState;
import provenda.pos.backend.generic.entity.LifeCycleEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class AbstractQueryServiceImpl<T extends LifeCycleEntity<T>, ID extends Serializable>
		implements AbstractQueryService<T, ID> {
	
	@Autowired
	private AbstractBaseRepository<T, ID> repository;
	
	@Override
	public Mono<T> findById(ID id) {
		
		return repository.findById(id);
	}

	@Override
	public Flux<T> findAll() {
		return repository.findAll();
	}

	@Override
	public Flux<T> findByActiveAndState(LifeCyCleState lifeCyCleState) {
	
		return repository.findByActiveAndState(lifeCyCleState.isActive(),lifeCyCleState.getState());
	}

}
