package com.common;

public class ContextHolder {
	public static final String postgres_db="postgres_db";
	public static final String mysql_db="mysql_db";

	private static final ThreadLocal<String> context = new ThreadLocal<String>();

	public static void setConsumerType(String consumerType){
		context.set(consumerType);
	}

	public static String getConsumerType(){
		return context.get();
	}

	public static void clearConsumerType(){
		context.remove();
	}
}
