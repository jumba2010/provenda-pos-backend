package provenda.pos.backend.product.service;

import provenda.pos.backend.product.entity.ProductEntity;
import provenda.pos.backend.security.UserContext;
import provenda.pos.backend.stock.entity.ProductStock;
import reactor.core.publisher.Mono;

public interface ProductService {
	
	public abstract Mono<ProductEntity> createProduct(UserContext userContext,Mono<ProductEntity> product);
	
	public abstract void updateStock(UserContext userContext,ProductStock productStock);
	
}
