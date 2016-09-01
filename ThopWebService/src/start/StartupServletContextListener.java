package start;

import javax.servlet.*;

public class StartupServletContextListener implements ServletContextListener {
	Start s;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		s.endMethod();

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		s = new Start();
		s.startMethod();

	}

}
