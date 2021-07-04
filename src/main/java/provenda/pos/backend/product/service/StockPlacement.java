package provenda.pos.backend.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import provenda.pos.backend.generic.service.AbstractService;
import provenda.pos.backend.product.dao.ProductRepository;
import provenda.pos.backend.product.entity.ProductEntity;
import provenda.pos.backend.security.UserContext;
import provenda.pos.backend.stock.entity.ProductStock;
import provenda.pos.backend.stock.entity.StockEntity;
import provenda.pos.backend.stock.entity.StockType;

/**
 * @author Judiao Mbaua
 *
 *         <p>
 *         This class will be responsible for caring all the logic about
 *         incrementing the Stock
 *         </p>
 */
@Component
@AllArgsConstructor
public class StockPlacement implements StockUpdateType {

	@Autowired
	private AbstractService<ProductEntity, Long> productService;
	
	@Autowired
	private AbstractService<StockEntity, Long> stockService;

	@Autowired
	private ProductRepository productRepo;

	@Override
	public void updateStock(UserContext userContext, ProductStock productStock) {
		StockEntity stock = new StockEntity();
		stock.setStockType(StockType.ENTRANCE.getType());
		stock.setProductId(productStock.getProductId());
		stock.setAvailableQuanity(productStock.getQuantity());
		stock.setSellPrice(productStock.getSellPrice());
		stock.setPurchasePrice(productStock.getPurchasePrice());
		stock.setQuantity(productStock.getQuantity());
		stockService.create(userContext, stock);

		productRepo.findById(productStock.getProductId()).subscribe(p -> {
			p.setCurrentPrice(productStock.getSellPrice());
			p.setAvailableQuantity(p.getAvailableQuantity() - productStock.getQuantity());
			productService.update(userContext, p);
		});

	}

}
