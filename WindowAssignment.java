package week3.day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		 
		//Loading the URL -get
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//Maximize the browser
	     driver.manage().window().maximize();
	     
	     //sendKeys - To enter data in text field
	     //Enter the username  -findElement
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	     driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
	     
	     //Enter the password
	     driver.findElement(By.id("password")).sendKeys("crmsfa");
	     
	     //Click on the login button
	     driver.findElement(By.className("decorativeSubmit")).click();
	     //Click on the CRMSFA link
	     driver.findElement(By.linkText("CRM/SFA")).click();
	     //click on contacts button
	     driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	     //click on merge contact
	     driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
	     //click on widget with the help of relative locators
	     WebElement textbox1 = driver.findElement(By.xpath("//input[@class='XdijitInputField dijitInputFieldValidationNormal']"));
	     driver.findElement(with(By.tagName("a")).toRightOf(textbox1)).click();
	     
	     
	   //get tittle of child window
			Set<String> windowHandles = driver.getWindowHandles();
			
			//set to list
			List<String> allWindows=new ArrayList<String>(windowHandles);
			
			driver.switchTo().window(allWindows.get(1));
			String title = driver.getTitle();
			//String title = driver.getTitle();
			
			System.out.println("child window tittle: "+title);
			
			driver.switchTo().window(allWindows.get(1));
			driver.manage().window().maximize();
			
			//click on first contact
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
			//switch to parent window
			driver.switchTo().window(allWindows.get(0));
			System.out.println(driver.getTitle());
			//click on widget next to To contact
			driver.findElement(By.xpath("(//img[@src=\"/images/fieldlookup.gif\"])[2]")).click();
			
			Set<String> w = driver.getWindowHandles();
			
			//set to list
			List<String> All=new ArrayList<String>(w);
			
			driver.switchTo().window(All.get(1));
			driver.manage().window().maximize();
			
			//click on second contact
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
			//switch to parent window
			driver.switchTo().window(All.get(0));
			//click on merge button
			driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
			//handling alret
			driver.switchTo().alert().accept();
			System.out.println("Tittle of the page: "+driver.getTitle());
			
			

	}

}
