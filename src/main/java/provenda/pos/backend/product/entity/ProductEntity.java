package provenda.pos.backend.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import provenda.pos.backend.generic.entity.LifeCycleEntity;
import provenda.pos.backend.sale.entity.PromotionEntity;
import provenda.pos.backend.user.entity.SucursalEntity;

/**
 * @author Judiao Mbaua
 *
 *<p>This class holds the <b>product details<b/></p>
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name="product")
public class ProductEntity extends LifeCycleEntity<Long> {

	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private String code;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="can_be_sold", nullable = false)
	private boolean canBeSold;
	
	@Column(name="alert_quantity")
	private int alertQuantity;
	
	@Column(name="available_quantity")
	private int availableQuantity;
	
	@Column(name="package_count")
	private int packageCount;
	
	@Column(name="current_price", nullable = false)
	private double currentPrice;
	
	@Column(name="promotional_price", nullable = false)
	private double pomotionalPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="sucursal_id",insertable = false,updatable=false,nullable = false)
	private SucursalEntity sucursal;
	
	@Column(name="sucursal_id")
	private Long sucursalId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="unity_id_id",insertable = false,updatable=false,nullable = false)
	private UnityEntity unity;
	
	@Column(name="unity_id")
	private Long unityId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id",insertable = false,updatable=false,nullable = false)
	private CategoryEntity category;
	
	@Column(name="promotion_id")
	private Long promotionId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id",insertable = false,updatable=false,nullable = false)
	private PromotionEntity promotion;
	
	@Column(name="category_id")
	private Long categoryId;
	
	@Column(name="dafault_tax")
	private double defaultTax;
	
}
