package com.user.page;

import java.io.Serializable;

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

public class EditorUserPanel extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1770040510175448466L;
	private static final Logger logger = LoggerFactory.getLogger(EditorUserPanel.class);
	
	@SpringBean
	private IUserService iUserService;
	
	public EditorUserPanel(String id,Model<Serializable> model) {
		super(id);
		// TODO Auto-generated constructor stub
		final User user = (User)model.getObject();
		final TextField<String> name = new TextField<String>("name",new Model<String>(user.getName()));
		final TextField<Integer> age = new TextField<Integer>("age", new Model<Integer>(user.getAge()));
		final TextField<String> photo = new TextField<String>("photo", new Model<String>(user.getPhoto()));
		
		Form<User> form = new Form<User>("form",new CompoundPropertyModel<User>(user)){
			private static final long serialVersionUID = -1015640227541949220L;
			
			@Override
			protected void onSubmit() {
				super.onSubmit();
				
				String nm = name.getValue();
				String a = age.getValue();
				String p = photo.getValue();
				user.setName(nm);
				user.setAge(Integer.parseInt(a));
				user.setPhoto(p);
				iUserService.update(user);
				logger.info("更新成功!");
				getPage().replace(new UserListPanel("active"));
			}
			
		};

		form.add(name);
		form.add(age);
		form.add(photo);

		add(form);
		
	}

}
