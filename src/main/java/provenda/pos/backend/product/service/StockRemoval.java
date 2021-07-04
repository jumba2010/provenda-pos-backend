package provenda.pos.backend.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import provenda.pos.backend.generic.service.AbstractService;
import provenda.pos.backend.product.dao.ProductRepository;
import provenda.pos.backend.product.entity.ProductEntity;
import provenda.pos.backend.security.UserContext;
import provenda.pos.backend.stock.dao.StockRepository;
import provenda.pos.backend.stock.entity.ProductStock;
import provenda.pos.backend.stock.entity.StockEntity;
import reactor.core.publisher.Flux;

/**
 * @author Judiao Mbaua
 *
 *         <p>
 *         This class will be responsible for caring all the logic about
 *         decrementing the Stock
 *         </p>
 */
@Component
@AllArgsConstructor
public class StockRemoval implements StockUpdateType {

	@Autowired
	private AbstractService<ProductEntity, Long> productService;

	@Autowired
	private AbstractService<StockEntity, Long> stockService;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private StockRepository StockRepo;

	@Override
	public void updateStock(UserContext userContext, ProductStock productStock) {

		Flux<StockEntity> stocks = StockRepo.findByAvailableQuanityGreaterThanOrderById(0);

		productRepo.findById(productStock.getProductId()).subscribe(p -> {
			p.setCurrentPrice(productStock.getSellPrice());
			p.setAvailableQuantity(p.getAvailableQuantity() - productStock.getQuantity());
			productService.update(userContext, p);
		});

		// Keep decrementing the stock until the quantity to decrement is zero
		stocks.toStream().forEach(stock -> {
			if (productStock.getQuantity() != 0) {

				int dif = stock.getAvailableQuanity() - productStock.getQuantity();
				if (dif < 0) {

					productStock.setQuantity(productStock.getQuantity() - stock.getAvailableQuanity());
					stock.setAvailableQuanity(0);
				}

				else {
					productStock.setQuantity(0);
					stock.setAvailableQuanity(dif);

				}

				stockService.update(userContext, stock);

			}
		});

	}

}
