package com.com.thai.dang.entity;

public interface EntityEvent<T> {
	
	void beforeAdd(T t);

	void beforeUpdate(T t);

	void beforeDelete(T t);
	
	void afterLoad(T t);

	void afterSave(T t);

	void afterUpdate(T t);

	void afterDelete(T t);
}
