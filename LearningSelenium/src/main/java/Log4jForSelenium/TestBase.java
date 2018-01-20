package Log4jForSelenium;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;

public class TestBase {
	private static final Logger logger = Logger.getLogger(TestBase.class.getName());
	
	@BeforeTest
	public void loadLog4j(){
		String log4jConfPath = System.getProperty("user.dir")+"/src/main/java/Log4jForSelenium/Log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		logger.info("Starting BeforeTest");
	}
}
