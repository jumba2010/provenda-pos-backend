package provenda.pos.backend.user.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import provenda.pos.backend.user.entity.UserEntity;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<UserEntity
, Long>{

	
	@Query("Select u from UserEntity u INNER JOIN FETCH u.profile INNER JOIN FETCH u.sucursal WHERE u.sucursalId IN :sucursalIds ")
	public abstract Flux<UserEntity> findUserBySucursalIds(@Param("sucursalIds")Set<Long> sucursalIds );
}
