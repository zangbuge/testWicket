package com.layout.simpleLoginPage;

import com.layout.jugTemlate.JugTemplate;
import com.layout.loginPanel.LoginPanel;

public class SimpleLoginPage extends JugTemplate{

	private static final long serialVersionUID = 616798304351456069L;

	public SimpleLoginPage(){
		super();
		replace(new LoginPanel(CONTENT_ID));
//		getMenuPanel().setVisible(false);   //设置左侧菜单隐藏
	}

}
