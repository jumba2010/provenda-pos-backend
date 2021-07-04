package provenda.pos.backend.sale.service;

import provenda.pos.backend.sale.entity.SaleEntity;
import provenda.pos.backend.security.UserContext;
import reactor.core.publisher.Mono;

public interface SaleService {
	
	public abstract Mono<SaleEntity> createSale(UserContext userContext,Mono<SaleEntity> sale);
	
	public abstract Mono<SaleEntity> cancelSale(UserContext userContext,Mono<SaleEntity> sale);
	
}
