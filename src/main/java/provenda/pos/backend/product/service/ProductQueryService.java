package provenda.pos.backend.product.service;

import provenda.pos.backend.product.entity.ProductEntity;
import provenda.pos.backend.security.UserContext;
import provenda.pos.backend.stock.entity.StockEntity;
import reactor.core.publisher.Flux;

public interface ProductQueryService {
	
public abstract Flux<ProductEntity> findProductBySucursal(UserContext userContext,Long SucursalId);


public abstract Flux<StockEntity> findStockBySucursalIdAndActiveAndState(UserContext userContext,Long SucursalId);
}
