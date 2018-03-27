package com.common;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)  // 设置拦截顺序
public class DatasourceAspect {
	private static final Logger logger = LoggerFactory.getLogger(DatasourceAspect.class);

	@Pointcut("execution (* com.student..*.*(..))")
	public void pointCut(){
		// 该方法不用写内容,只为了给注解切点一个挂载入口
	}

	@Before("pointCut()")
	public void testBefore(JoinPoint point) throws NoSuchMethodException, SecurityException{
		logger.info("数据库切换拦截...");
		// 反射获取目标对象
		Class<?>[] classz = point.getTarget().getClass().getInterfaces();
		//获得访问的方法名
		String methodName = point.getSignature().getName();
		logger.info("方法名称:{}",methodName);
		//得到方法的参数的类型
		Class<?>[] parameterTypes = ((MethodSignature)point.getSignature()).getParameterTypes();
		// 获取方法
		Method method = classz[0].getMethod(methodName, parameterTypes);
		boolean boo = method.isAnnotationPresent(IChooseDataSource.class);
		if(boo){
			IChooseDataSource dataSource = method.getAnnotation(IChooseDataSource.class);
			//设置动态的数据源
			ContextHolder.setConsumerType(dataSource.value());
			logger.info("切换数据源成功,数据源:{}",dataSource.value());
		}
	}
	
	

}
