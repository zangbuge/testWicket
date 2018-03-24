package com.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.layout.simpleLoginPage.SimpleLoginPage;
import com.login.Login;
import com.vo.User;

/**该类为html页面的数据javabean,类名必须和该数据挂载的html名称一致
 * @author: Administrator
 * @date: 2017年11月14日
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	private Label label1;
	
	private Label label2;

	public HomePage() {
		
		// 绑定页面的 wicket:id="label" 标签
		label1 = new Label("label", "label values11111");
		label2 = new Label("label", "label values22222");
		
		
		// 修改标签属性
		label2.add(new AttributeModifier("style", "color:red;font-weight:bold"));
		
		
		// 改变标签的值
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
		
		//标记片段,定义了一个片段在一个页面,我们使用它作为内容区域:
		//使wicket:id="fragmentId"的内容替换掉 id = "contentArea"的内容
		Fragment fragment = new  Fragment ("contentArea", "fragmentId", this);
		add(fragment);
		
		
		//给html中的标签添加内容
		add(new Label("helloMessage", "Hello WicketWorld! from java"));
		
		//添加一个链接,跳转到另一个页面
		add(new Link<Void>("login"){// "login" 对应html标签的id
			private static final long serialVersionUID = -546827954856297675L;

			@Override
			public void onClick() {
				//他版本setResponsePage需要在页面输入一个页面实例,而不是类:
				/*AnotherPage anotherPage = new AnotherPage();
		        setResponsePage(anotherPage);*/
				
				// 页面之间传递参数
				PageParameters pageParameters = new PageParameters();
				//add a couple of parameters
				pageParameters.add("name", "John");
				pageParameters.add("age", 28);
				//retrieve the value of 'age' parameter
				pageParameters.get("age");
				//跳向的页面
				setResponsePage(Login.class,pageParameters);
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
		
		
		//使用model设置标签数据
		User user = new User();
		user.setName("张三");
		Model<String> model = new Model<String>(user.getName());
		//静态实现
		label1 = new Label("testModelId", model);
		
		//动态实现
		PropertyModel<Object> propertyModel = new PropertyModel<Object>(user, "name");
		label1 = new Label("testModelId", propertyModel);
		// 挂载上标签数据
		add(label1);
		
		
		
		// li标签的使用
		RepeatingView listItems = new RepeatingView("listItems");
		listItems.add(new Label(listItems.newChildId(), "li标签的用法"));
		listItems.add(new Label(listItems.newChildId(), "green"));
		listItems.add(new Label(listItems.newChildId(), "blue"));
		listItems.add(new Label(listItems.newChildId(), "red"));
		add(listItems);
		
		// 使用Listview 组件,显示一个给定的对象列表
		List<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setName("鱼人");
		user1.setAge(12);
		users.add(user1);
		User user2 = new User();
		user2.setName("李四");
		users.add(user2);
		ListView<User> listView = new ListView<User>("users",users) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<User> item) {
				// name 为user中定义的属性
				item.add(new Label("userName", new PropertyModel<Object>(item.getModel(), "name")));
			}
		};
		
		add(listView);
		
		
		// ajax 的使用
		label1 = new Label("showValueID","显示ajax的信息");
		// 自动生成标记id,必须
		label1.setOutputMarkupId(true);
		add (label1);
		AjaxLink<Void> ajaxLink = new AjaxLink<Void>("ajaxLink") {
			private static final long serialVersionUID = 6003762593034849892L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				// TODO Auto-generated method stub
				label1.setDefaultModel(new Model<String>("ajax返回的消息"));
				// 设置响应对象
				target.add(label1);
				// 添加js脚本
				target.appendJavaScript(";alert('Hello!!');");
			}
		};
		add(ajaxLink);
		
		
		// 添加一个模态弹窗
		final ModalWindow modalWindow = new ModalWindow("modalWindow");
        Label label = new Label(modalWindow.getContentId(), "I'm a modal window!");
        modalWindow.setContent(label);
        modalWindow.setTitle("Modal window");
        add(modalWindow);
        AjaxLink<Void> mw = new AjaxLink<Void>("openWindow") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget arg0) {
				modalWindow.show(arg0);
			}
		};
		add(mw);
		
		
	}
}