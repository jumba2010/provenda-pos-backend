package provenda.pos.backend.product.service;

import provenda.pos.backend.security.UserContext;
import provenda.pos.backend.stock.entity.ProductStock;

public interface StockUpdateType {

	public abstract void updateStock(UserContext usercontext,ProductStock productStock);
}
