/**
 * 
 */
package com.inheritance.config;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * @author eduardaalves
 *
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID>  extends PagingAndSortingRepository<T, ID>{
	
	@Query("update #{#entityName} e set e.deleted=true where e.id = ?1")
	@Transactional
	@Modifying
	void softDelete(ID id);

}
