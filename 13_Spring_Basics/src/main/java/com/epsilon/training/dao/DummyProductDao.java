package com.epsilon.training.dao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummyProductDao implements ProductDao {
	
	public DummyProductDao() {
		log.debug("From DummyProduct Dao");
	}
	
	@Override
	public long count() {
		return 1000;
	}

}
