package br.com.topmake.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class HibernateContexto implements ServletContextListener  {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtil.getFabricaDeSessoes().close();
	}
		
	@Override
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getFabricaDeSessoes().openSession();
		
	}
	

}
