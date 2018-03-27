package com.common;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**自定义注解, 使用时一定要放在业务的接口中,放在实现类中不生效
 * @author lhm
 * @time  2018年3月27日
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IChooseDataSource {
	// 并添加默认返回 
	String value() default ContextHolder.mysql_db;
	
}
