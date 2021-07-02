package provenda.pos.backend.product.dao;

import org.springframework.data.repository.CrudRepository;

import provenda.pos.backend.product.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity
, Long>{

}
