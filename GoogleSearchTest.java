package googleSearch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D://Softwares//JAVA//chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);

		driver.findElement(By.name("q")).sendKeys("youtube");
		Thread.sleep(5000);

		List <WebElement> list=driver.findElements(By.xpath("//ul[@role=\"listbox\"]//li/descendant::div[@class='pcTkSc']"));
		System.out.println(list.size());

		for (int i=0;i<list.size();i++) {
			String listitem=list.get(i).getText();
			
			System.out.println(listitem);
			if (listitem.contains("youtube download")) {
				list.get(i).click();
				break;
			}
		}
		
	}

}
