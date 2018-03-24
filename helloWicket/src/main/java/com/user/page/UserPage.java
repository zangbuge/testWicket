package com.user.page;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

public class UserPage extends WebPage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4346764065164993663L;

	private Component addUser = null;
	private Component userList = null;

	public UserPage(){
		Label label = new Label("addUser","添加用户");
		add(label);
		label = new Label("updateUser","更新用户");
		add(label);
		label = new Label("deleteUser","删除用户");
		add(label);

		// 添加   添加用户页面的
		add(addUser = new AddUserPanel("active"));

		// 添加获取用户事件
		Link<Void> getUser = new Link<Void>("getUser") {
			private static final long serialVersionUID = -4092082780066893680L;

			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				userList = new UserListPanel("active");
				//获取当前的页面,这一步很关键. 替换掉之前的组件
				getPage().replace(userList);
			}
		};
		//添加getuser事件
		add(getUser);
	}




	public Component getUserList() {
		return userList;
	}

	public void setUserList(Component userList) {
		this.userList = userList;
	}

	public Component getAddUser() {
		return addUser;
	}

	public void setAddUser(Component addUser) {
		this.addUser = addUser;
	}

}
