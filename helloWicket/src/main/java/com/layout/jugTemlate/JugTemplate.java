package com.layout.jugTemlate;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import com.layout.footerPanel.FooterPanel;
import com.layout.headerPanel.HeaderPanel;
import com.layout.menuPanel.MenuPanel;

public class JugTemplate extends WebPage{

	private static final long serialVersionUID = 891886514074060631L;

	public static final String CONTENT_ID = "contentComponent";

	private Component headerPanel;
	private Component menuPanel;
	private Component footerPanel;
	
	public JugTemplate(){
		add(headerPanel = new HeaderPanel("headerPanel"));
		add(menuPanel = new MenuPanel("menuPanel"));
		add(footerPanel = new FooterPanel("footerPanel"));
		add(new Label(CONTENT_ID, "Put your content here"));
	}
	
	
	public Component getHeaderPanel() {
		return headerPanel;
	}


	public void setHeaderPanel(Component headerPanel) {
		this.headerPanel = headerPanel;
	}


	public Component getMenuPanel() {
		return menuPanel;
	}


	public void setMenuPanel(Component menuPanel) {
		this.menuPanel = menuPanel;
	}


	public Component getFooterPanel() {
		return footerPanel;
	}


	public void setFooterPanel(Component footerPanel) {
		this.footerPanel = footerPanel;
	}


	

}
