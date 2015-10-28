package br.com.topmake.bean;

import javax.faces.bean.ManagedBean;

import org.omnifaces.util.Messages;

@ManagedBean
public class LoginBean {
	public void Login() {
		Messages.addGlobalInfo("Programação Web com Java");
	}
}