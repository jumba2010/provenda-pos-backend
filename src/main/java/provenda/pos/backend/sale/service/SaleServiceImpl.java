package provenda.pos.backend.sale.service;

import org.springframework.beans.factory.annotation.Autowired;

import provenda.pos.backend.generic.service.AbstractService;
import provenda.pos.backend.sale.entity.SaleEntity;
import provenda.pos.backend.sale.entity.SaleItemEntity;
import provenda.pos.backend.sale.entity.SaleStatus;
import provenda.pos.backend.security.UserContext;
import reactor.core.publisher.Mono;

public class SaleServiceImpl implements SaleService {

	@Autowired
	private AbstractService<SaleEntity, Long> saleService;
	
	@Autowired
	private AbstractService<SaleItemEntity, Long> saleItemService;

	@Override
	public Mono<SaleEntity> createSale(UserContext userContext, Mono<SaleEntity> sale) {
		
		sale.subscribe(s->{
			saleService.create(userContext, s);	
			s.getItems().stream().forEach(i->{
				i.setSaleId(s.getId());
				saleItemService.create(userContext, i);	
			});
		});
		
		return sale;
	}

	@Override
	public Mono<SaleEntity> cancelSale(UserContext userContext, Mono<SaleEntity> sale) {
		sale.subscribe(s->{
			s.setStatus(SaleStatus.CANCELED.getStatus());
			saleService.update(userContext, s);
			
		});
		
		return sale;
	}




}
