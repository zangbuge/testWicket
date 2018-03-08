package com.page;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Fragment;

import com.layout.simpleLoginPage.SimpleLoginPage;
import com.login.Login;

/**该类为html页面的数据javabean,类名必须和该数据挂载的html名称一致
 * @author: Administrator
 * @date: 2017年11月14日
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	private Label label1;
	
	private Label label2;

	public HomePage() {
		
		
		// 改变标签的值
		label1 = new Label("label", "label values11111");
		label2 = new Label("label", "label values22222");
		add(label1);
		add(new Link<Void>("reload"){
			private static final long serialVersionUID = -546827954856297675L;

			@Override
			public void onClick() {
				if (getPage().contains(label1, true)) 
					getPage().replace(label2);
				else
					getPage().replace(label1);
			}
			
		});
		
		
		// 修改标签属性未测试通过
		
		//标记片段,定义了一个片段在一个页面,我们使用它作为内容区域:
		//使wicket:id="fragmentId"的内容替换掉 id = "contentArea"的内容
		Fragment fragment = new  Fragment ("contentArea", "fragmentId", this);
		add(fragment);
		
		//给html中的标签添加内容
		add(new Label("helloMessage", "Hello WicketWorld!"));

		//添加一个链接
		add(new Link<Void>("login"){// "login" 对应html标签的id
			private static final long serialVersionUID = -546827954856297675L;

			@Override
			public void onClick() {
				//他版本setResponsePage需要在页面输入一个页面实例,而不是类:
				/*AnotherPage anotherPage = new AnotherPage();
		        setResponsePage(anotherPage);*/

				//跳向的页面
				setResponsePage(Login.class);
			}

		});

		//跳向布局面板
		add(new Link<Void>("panelID"){// "login" 对应html标签的id
			private static final long serialVersionUID = -54682795485659767L;

			@Override
			public void onClick() {
				//他版本setResponsePage需要在页面输入一个页面实例,而不是类:
				/*AnotherPage anotherPage = new AnotherPage();
				        setResponsePage(anotherPage);*/

				//跳向的页面
				SimpleLoginPage loginPage = new SimpleLoginPage();
				setResponsePage(loginPage);
			}

		});

	}
	
	

}