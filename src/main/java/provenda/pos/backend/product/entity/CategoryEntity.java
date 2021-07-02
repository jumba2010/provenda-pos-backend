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

/**
 * @author Judiao Mbaua
 *
 *<p>This class holds the <b>product category and sub categories<b/></p>
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name="category")
public class CategoryEntity extends LifeCycleEntity<Long> {

	@Column(name="image_url")
	private String imageURL;
	
	@Column(name="code", nullable = false)
	private String code;
	
	@Column(name="description",nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="parent_id",insertable = false,updatable=false,nullable = false)
	private CategoryEntity parent;
	
	@Column(name="parent_id")
	private Long parentId;
	
}
