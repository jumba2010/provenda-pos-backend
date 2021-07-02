package provenda.pos.backend.generic.entity;

import java.time.LocalDateTime;

public interface ILifeCycleEntity<T> {
	
	public T getId() ;

	public void setId(T id) ;

	public Long getCreatedBy();

	public void setCreatedBy(Long createdBy) ;

	public Long getUpdatedBy() ;

	public void setUpdatedBy(Long updatedBy);

	public Long getActivatedBy() ;
	
	public void setActivatedBy(Long activatedBy) ;
	
	public int getState() ;

	public void setState(int state);

	public boolean isActive() ;

	public void setActive(boolean active) ;

	public LocalDateTime getCreatedAt() ;

	public void setCreatedAt(LocalDateTime createdAt) ;

	public LocalDateTime getUpdatedAt();

	public void setUpdatedAt(LocalDateTime updatedAt) ;

	public LocalDateTime getActivatedAt() ;

	public void setActivatedAt(LocalDateTime activatedAt) ;

}
