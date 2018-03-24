package com.user.page;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.user.pojo.User;
import com.user.service.IUserService;

public class UserListPanel extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7866157953711370627L;
	
	@SpringBean	
	IUserService iUserService;

	public UserListPanel(String id) {
		super(id);
		// TODO Auto-generated constructor stub
		User user = new User();
		List<User> users = iUserService.getUsers(user);
		ListDataProvider<User> userList = new ListDataProvider<User>(users);
		
		DataView<User> userView = new DataView<User>("rows",userList) {
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(Item<User> item) {
				User u = item.getModelObject();
				RepeatingView repeatingView = new RepeatingView("dataRow");
				repeatingView.add(new Label(repeatingView.newChildId(),u.getName()));
				repeatingView.add(new Label(repeatingView.newChildId(),u.getAge()));
				repeatingView.add(new Label(repeatingView.newChildId(),u.getPhoto()));
				item.add(repeatingView);
			}
		};
		// 添加分页
//		userView.setItemsPerPage(15);
		add(userView);
//		add(new PagingNavigator("pagingNavigator", userView));
		
	}

}
