package com.user.page;

import java.io.Serializable;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.user.pojo.User;
import com.user.service.IUserService;

public class ActionPanel extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6874408392710557003L;
	
	@SpringBean	
	IUserService iUserService;

	public ActionPanel(String id,final Object model) {
		super(id);
		// TODO Auto-generated constructor stub
		
		add(new Link<Void>("modify") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				// TODO 编辑操作
				User user = (User)model;
				Model<Serializable> userModel = new Model<Serializable>(user);
				getPage().replace(new EditorUserPanel("active", userModel));
			}
		});
		
		
		add(new Link<Void>("remove") {
			private static final long serialVersionUID = -5792386867151068845L;

			@Override
			public void onClick() {
				User user = (User)model;
				iUserService.delete(user.getId());
				getPage().replace(new UserListPanel("active"));
			}
			
		});
		
		
		
		
	}

}
