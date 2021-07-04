package provenda.pos.backend.sale.service;

import provenda.pos.backend.sale.entity.SaleEntity;
import provenda.pos.backend.security.UserContext;
import reactor.core.publisher.Flux;

public interface SaleQueryService {
	
	public abstract Flux<SaleEntity> findSalesByStatusAndSucursalIdAndActiveAndState(UserContext userContext, String status,
			Long sucursalId);
}
