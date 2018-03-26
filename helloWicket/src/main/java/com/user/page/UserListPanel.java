package com.user.page;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
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
		final List<User> users = iUserService.getUsers(user);
		ListDataProvider<User> userList = new ListDataProvider<User>(users);

		DataView<User> userView = new DataView<User>("rows",userList) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(Item<User> item) {
				final User u = item.getModelObject();

				RepeatingView repeatingView = new RepeatingView("dataRow");
				// 创建删除标签
				final Label delete = new Label(repeatingView.newChildId(),new Model<String>("删除"));
				delete.setOutputMarkupId(true);
				
				Link<Void> link = new Link<Void>(repeatingView.newChildId()) {
					private static final long serialVersionUID = 4362873349269038075L;

					@Override
					public void onClick() {
						// TODO Auto-generated method stub
						iUserService.delete(u.getId());
					}
				};
				link.setOutputMarkupId(true);
				
				// 添加操作组件
				ActionPanel actionPanel = new ActionPanel(repeatingView.newChildId(), u);
				repeatingView.add(actionPanel);
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


		// 在线编辑
	/*	List<IColumn<User, String>> columns = new ArrayList<IColumn<User, String>>();
		columns.add(new AbstractColumn<User, String>(Model.of("Actions")){
			private static final long serialVersionUID = -8068926012276059660L;

			public void populateItem(Item<ICellPopulator<User>> cellItem, String componentId,IModel<User> model){
				ActionPanel actionPanel = new ActionPanel(componentId, model);
				cellItem.add(actionPanel);
			}
		});
		columns.add(new PropertyColumn<User, String>(Model.of("ID"), "id"));
		columns.add(new PropertyColumn<User, String>(Model.of("First Name"), "firstName",
				"firstName"));
		columns.add(new PropertyColumn<User, String>(Model.of("Last Name"), "lastName",
				"lastName"));
		columns.add(new PropertyColumn<User, String>(Model.of("Home Phone"), "homePhone"));
		columns.add(new PropertyColumn<User, String>(Model.of("Cell Phone"), "cellPhone"));
		*/

	}


	/*	 private CheckGroup<User> createGroup(String id){

	        final CheckGroup<User> group = new CheckGroup<User>(id,new ArrayList<User>());

	        group.add(new CheckGroupSelector("groupSelector"));

	        //根据自己情况获得一个Element的List,生成ListView填充数据
	        List<User> list=iUserService.getUsers(new User());
	        List<User> checkUsers = new ArrayList<User>();
	        final ListView<User> listView = new ListView("rows", list) {

	            protected void populateItem(final ListItem item) {

	                //通过循环为ListView添加子控件
	                final User user = (User) item.getModelObject();

	                //为每一行添加chenk控件
	                item.add(new Check("selected",new Model(user)));

	                 在这里面你可以通过同样的方式，添加自己的列
	                item.setOutputMarkupId(true);
	            }

	        };

	        group.add(listView);

	        //当check被勾选上时，获取被勾选的一个对象，并且把对象放到提前定义好的集合里
	        group.add(new AjaxFormChoiceComponentUpdatingBehavior() {
	            @Override
	            protected void onUpdate(AjaxRequestTarget target) {
	            	User uu =(User)group.getModelObject();
	            	System.out.println(uu.getName());
	            }
	        });
	        return group;
	    }*/

}
