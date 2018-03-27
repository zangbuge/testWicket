package com.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSourceChoose extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return ContextHolder.getConsumerType();
	}

}
