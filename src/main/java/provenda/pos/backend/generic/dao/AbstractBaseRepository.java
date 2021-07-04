package provenda.pos.backend.generic.dao;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

/**
 * @author Judiao Mbaua
 * 
 *        <p> This a generic repository for all crud operations</p>
 *        @NoRepositoryBean anotation avoids JPA for finding an implementation for the repository
 *
 */
@NoRepositoryBean
public interface AbstractBaseRepository<T,  ID extends Serializable>
		extends ReactiveCrudRepository<T, ID> {

	Flux<T> findByActiveAndState(boolean active, int state);

}
