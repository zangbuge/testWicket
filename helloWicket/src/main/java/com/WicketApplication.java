package com;

import org.apache.wicket.ISessionListener;
import org.apache.wicket.core.request.mapper.CryptoMapper;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import com.login.Login;
import com.page.HomePage;

/**该累为项目初始化配置
 * @author lhm
 *
 */
public class WicketApplication extends WebApplication {
	
	
	/** 配置项目默认页
	 */
	@Override
	public Class<? extends WebPage> getHomePage(){
		return HomePage.class;
	}
	
	
	/**初始化其他配置
	 * */
	@Override
	public void init(){
		super.init();
		// add your configuration here

		//listener initialization...会话和听众,添加一下两行代码,在其他的地方可以使用session.
		ISessionListener myListener = null;
		getSessionListeners().add(myListener);
		
		//加密uri
		setRootRequestMapper(new CryptoMapper(getRootRequestMapper(), this));
		
		//挂载一个页面,生成该页面的uri,uri中可以使用${foo}
		/**
		 *  PageParameters pageParameters = new PageParameters();
			pageParameters.add("foo", "foo_value");

			setResponsePage(MountedPageWithPlaceholder.class, pageParameters)
		 */
		mountPage("/toLogin", Login.class);
		
	}
	
	
	
	
	
}
