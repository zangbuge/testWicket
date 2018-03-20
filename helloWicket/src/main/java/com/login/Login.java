package com.login;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Login extends WebPage{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 接收传过来的参数
	public Login(PageParameters pageParameters){
		super(pageParameters);
		System.out.println("页面传递 的name = " + pageParameters.get("name"));
		
		// 定义一个外部链接
		String googleQuery = "http://www.baidu.com";
		// 注意,后端的标签绑定一定要与前端的wicket:id 对应, 否则出现异常
		add(new ExternalLink("externalSite", googleQuery));
		// 该构造参数在添加一个字符串,可以替换掉 页面上显示的文字
//		add(new ExternalLink("externalSite", googleQuery, "跳向百度"));
		
	}

}
