package provenda.pos.backend.product.service;

import org.springframework.beans.factory.annotation.Autowired;

import provenda.pos.backend.generic.entity.LifeCyCleState;
import provenda.pos.backend.product.dao.ProductRepository;
import provenda.pos.backend.product.entity.ProductEntity;
import provenda.pos.backend.security.UserContext;
import provenda.pos.backend.stock.dao.StockRepository;
import provenda.pos.backend.stock.entity.StockEntity;
import reactor.core.publisher.Flux;

public class ProductQueryServiceImpl implements ProductQueryService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private StockRepository stockRepo;

	@Override
	public Flux<ProductEntity> findProductBySucursal(UserContext userContext, Long SucursalId) {
		return productRepo.findProductBySucursalIdAndActiveAndState(SucursalId, LifeCyCleState.ACTIVE.isActive(),
				LifeCyCleState.ACTIVE.getState());
	}

	@Override
	public Flux<StockEntity> findStockBySucursalIdAndActiveAndState(UserContext userContext, Long SucursalId) {
		return stockRepo.findStockBySucursalIdAndActiveAndState(SucursalId, LifeCyCleState.ACTIVE.isActive(),
				LifeCyCleState.ACTIVE.getState());
	}

}
