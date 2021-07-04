package provenda.pos.backend.product.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import provenda.pos.backend.product.entity.ProductEntity;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveCrudRepository<ProductEntity
, Long>{

	@Query("Select p from ProductEntity p INNER JOIN FETCH p.unity INNER JOIN FETCH p.category WHERE p.sucursalId = :sucursalId AND p.active = :active and p.state =:state")
	public abstract Flux<ProductEntity> findProductBySucursalIdAndActiveAndState(@Param("sucursalId")Long sucursalId,@Param("active") boolean active,@Param("state") int state );
}
