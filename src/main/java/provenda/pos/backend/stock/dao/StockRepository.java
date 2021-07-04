package provenda.pos.backend.stock.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import provenda.pos.backend.stock.entity.StockEntity;
import reactor.core.publisher.Flux;

public interface StockRepository extends ReactiveCrudRepository<StockEntity
, Long>{

	
public abstract Flux<StockEntity> findByAvailableQuanityGreaterThanOrderById(int quantity);

@Query("Select p from StockEntity s INNER JOIN FETCH s.product WHERE s.sucursalId = :sucursalId AND s.active = :active and s.state =:state")
public abstract Flux<StockEntity> findStockBySucursalIdAndActiveAndState(@Param("sucursalId")Long sucursalId,@Param("active") boolean active,@Param("state") int state );
}
