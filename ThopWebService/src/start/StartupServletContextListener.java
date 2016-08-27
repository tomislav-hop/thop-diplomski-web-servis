package start;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartupServletContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Start s = new Start();
		s.startMethod();
		
	}

}
