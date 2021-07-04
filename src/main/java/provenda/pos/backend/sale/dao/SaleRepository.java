package provenda.pos.backend.sale.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import provenda.pos.backend.sale.entity.SaleEntity;
import reactor.core.publisher.Flux;

public interface SaleRepository extends ReactiveCrudRepository<SaleEntity, Long> {

	@Query("Select p from SaleEntity s INNER JOIN FETCH s.items i INNER JOIN FETCH i.product WHERE s.status =:status AND s.sucursalId = :sucursalId AND s.active = :active and s.state =:state")
	public abstract Flux<SaleEntity> findSalesByStatusAndSucursalIdAndActiveAndState(@Param("status") String status,
			@Param("sucursalId") Long sucursalId, @Param("active") boolean active, @Param("state") int state);
}
