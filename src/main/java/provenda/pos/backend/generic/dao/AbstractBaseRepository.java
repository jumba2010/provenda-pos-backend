package provenda.pos.backend.generic.dao;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import provenda.pos.backend.generic.entity.LifeCycleEntity;

/**
 * @author Judiao Mbaua
 * 
 *        <p> This a generic repository for all crud operations</p>
 *        @NoRepositoryBean anotation avoids JPA for finding an implementation for the repository
 *
 */
@NoRepositoryBean
public interface AbstractBaseRepository<T extends LifeCycleEntity<T>, ID extends Serializable>
		extends JpaRepository<T, ID> {

	Collection<T> findByActiveAndState(boolean active, int state);

}
