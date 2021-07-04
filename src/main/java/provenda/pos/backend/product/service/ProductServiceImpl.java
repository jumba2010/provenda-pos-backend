package provenda.pos.backend.product.service;

import org.springframework.beans.factory.annotation.Autowired;

import provenda.pos.backend.generic.service.AbstractService;
import provenda.pos.backend.product.entity.ProductEntity;
import provenda.pos.backend.security.UserContext;
import provenda.pos.backend.stock.entity.ProductStock;
import provenda.pos.backend.stock.entity.StockType;
import reactor.core.publisher.Mono;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private AbstractService<ProductEntity, Long> productService;

	@Autowired
	private StockRemoval stockRemoval;

	@Autowired
	private StockPlacement stockPlacement;

	@Override
	public Mono<ProductEntity> createProduct(UserContext userContext, Mono<ProductEntity> product) {
		product.subscribe(s -> {
			productService.create(userContext, s);
			ProductStock stock = new ProductStock();
			stock.setProductId(s.getId());
			stock.setSellPrice(s.getCurrentPrice());
			stock.setQuantity(s.getAvailableQuantity());
			stockPlacement.updateStock(userContext, stock);

		});

		return product;
	}

	@Override
	public void updateStock(UserContext userContext, ProductStock productStock) {

		if (productStock.getStockType().equals(StockType.ENTRANCE.getType())) {
			stockPlacement.updateStock(userContext, productStock);

		} else {
			stockRemoval.updateStock(userContext, productStock);
		}
		
	}

}
