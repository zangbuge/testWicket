package com.layout.loginPanel;

import java.io.File;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.lang.Bytes;


public class LoginPanel extends Panel {

	private final FileUploadField fileUploadField;
	
	private static final long serialVersionUID = 5902817109284565968L;
	public LoginPanel(String id) {
		super(id);
		
		final TextField<String> username = new TextField<String>("Username",new Model<String>("请输入用户名"));
		final PasswordTextField password = new PasswordTextField("Password", new Model<String>("请输入密码"));
		fileUploadField = new FileUploadField("fileUpload");
		
		Form<Void> form=new Form<Void>("loginForm"){
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				super.onSubmit();
				
				String un = username.getValue();
				String pwd = password.getValue();
				System.out.println("username = " + un + ", password = " + pwd);
				//上传文件
				if (fileUploadField != null) {
					FileUpload uploadField = fileUploadField.getFileUpload();
					File file = new File("c:/" + uploadField.getClientFileName());
					System.out.println("文件上传成功,filename = " + uploadField.getClientFileName());
					try {
						uploadField.writeTo(file);
						info("Upload completed!");
					} catch (Exception e) {
						e.printStackTrace();
						error("Upload failed!");
					}
				}
				
			}
		};

		form.add(username);
		form.add(password);
		form.add(fileUploadField);
		form.setMultiPart(true);
		form.setMaxSize(Bytes.kilobytes(1000));
		add(form);
	}
}

