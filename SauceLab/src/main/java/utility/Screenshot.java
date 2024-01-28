package utility;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	

public static void clickScreenshot(WebDriver driver, String name)  throws IOException
{
	
 File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 
 File destination=new File("E:\\eclipse_workspace\\Facebook\\ScreenShots"+name+".jpeg");
 
FileHandler.copy(source, destination);
	
}

}
