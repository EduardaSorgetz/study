package com.inheritance.config;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author nicolas.wojcichoski
 *
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

	protected boolean deleted;
//	protected String createdBy;
//	protected String updatedBy;
	protected LocalDateTime createdAt;
//	protected LocalDateTime updatedAt;
//
//	@PrePersist
//	private void beforeInsert() {
//		this.deleted = false;
//		this.createdAt = LocalDateTime.now();
//		this.updatedAt = this.createdAt;
//	}
//
//	@PreUpdate
//	private void beforeUpdate() {
//		this.updatedAt = LocalDateTime.now();
//	}
}
