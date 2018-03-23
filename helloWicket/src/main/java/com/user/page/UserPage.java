package com.user.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.Component;

public class UserPage extends WebPage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4346764065164993663L;
	
	private Component addUser = null;
	
	public UserPage(){
		Label label = new Label("addUser","添加用户");
		add(label);
		label = new Label("updateUser","更新用户");
		add(label);
		label = new Label("deleteUser","删除用户");
		add(label);
		label = new Label("getUser","查询用户");
		add(label);
		// 添加   添加用户页面的
		add(addUser = new AddUserPanel("active"));
	}

	public Component getAddUser() {
		return addUser;
	}

	public void setAddUser(Component addUser) {
		this.addUser = addUser;
	}

}
