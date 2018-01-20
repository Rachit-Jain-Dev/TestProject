package Log4jForSelenium;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestLog4j extends TestBase{
	private static Logger logger = Logger.getLogger(TestLog4j.class.getName());
	
	@Test
	public void testLogin(){
		logger.info("Starting Login Test");
		logger.info("Clicked on [Sign in]");
		logger.info("Enter User Name");
		logger.info("Enter Password");
		logger.info("Clicked on [Submit]");
	}
}
