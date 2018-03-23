package com.user.page;

import java.util.UUID;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.user.pojo.User;
import com.user.service.IUserService;

public class AddUserPanel extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2610154220466090205L;
	private static final Logger logger = LoggerFactory.getLogger(AddUserPanel.class);
	
	@SpringBean
	private IUserService iUserService;

	public AddUserPanel(String id) {
		super(id);
		// TODO Auto-generated constructor stub
		User user = new User();
		final TextField<String> name = new TextField<String>("name",new Model<String>("请输入用户名"));
		final TextField<String> age = new TextField<String>("age", new Model<String>("请输入年龄"));
		final TextField<String> photo = new TextField<String>("photo", new Model<String>("请输入图片地址"));
		
		Form<User> form = new Form<User>("form",new CompoundPropertyModel<User>(user)){
			private static final long serialVersionUID = -1015640227541949220L;
			
			@Override
			protected void onSubmit() {
				super.onSubmit();
				
				String nm = name.getValue();
				String a = age.getValue();
				String p = photo.getValue();
				User user = new User();
				user.setId(UUID.randomUUID().toString());
				user.setName(nm);
				user.setAge(Integer.parseInt(a));
				user.setPhoto(p);
				iUserService.add(user);
				logger.info("添加成功!");
			}
			
		};

		form.add(name);
		form.add(age);
		form.add(photo);

		add(form);

	}

}
