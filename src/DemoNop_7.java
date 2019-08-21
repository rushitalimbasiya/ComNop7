import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/*7.	opening demo.nopcommerce.com, registering an account on this website,
after registering log out and log in again with registered email address and password,
adding a virtual gift card in the cart,
after filling all personal detail,
send an Email a friend,
send an email and assert the final message.
a.	Date stamp for the unique email address.
 */

public class DemoNop_7 extends Util{
 public static void main(String[] args) {

//add commit name
     System.setProperty("webdriver.chrome.driver", "src\\Resources\\chromedriver.exe");
     driver = new ChromeDriver();
     driver.get("https://demo.nopcommerce.com/");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

      //click on register
     clickOnElement(By.className("ico-register"));

     //click on male
     clickOnElement(By.id("gender-male"));
     //for first name
     clearOnElement(By.id("FirstName"));
     sendKey(By.id("FirstName"),"Dev");
     //for last name
     clearOnElement(By.id("LastName"));
     sendKey(By.id("LastName"),"patel");
     //for date
     byValue(driver.findElement(By.name("DateOfBirthDay")),"15");
     //for month
     byValue(driver.findElement(By.name("DateOfBirthMonth")),"5");
     //for year
     byValue(driver.findElement(By.name("DateOfBirthYear")),"1984");

     //for email
     clearOnElement(By.id("Email"));
     clickOnElement(By.id("Email"));
     sendKey(By.id("Email"),"abcd" + GetCurrentTimeStamp() + "@yahoo.com");

      //for company name
     clearOnElement(By.id("Company"));
     sendKey(By.id("Company"),"abcd");
     //for password
     clearOnElement(By.id("Password"));
     sendKey(By.id("Password"),"abcde@");
     //for confirm password
     sendKey(By.id("ConfirmPassword"),"abcde@");
     clickOnElement(By.id("register-button"));
     //for logout button
     clickOnElement(By.className("ico-logout"));
     //for log in button
     clickOnElement(By.className("ico-login"));

     //for email
     clickOnElement(By.id("Email"));
     sendKey(By.id("Email"),"abcd" + GetCurrentTimeStamp() + "@yahoo.com");
     //for password
     clickOnElement(By.id("Password"));
     sendKey(By.id("Password"),"abcde@");
      //click on log in button
     clickOnElement(By.xpath("//div[@class='buttons']/input[@class='button-1 login-button']"));
     //click on gift card
     clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li[7]/a"));
     //$25 Virtual Gift Card add to cart
     clickOnElement(By.xpath("//div[@class='buttons']/input[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/43/1/1\"),!1']"));
     //for RecipientName
     clickOnElement(By.name("giftcard_43.RecipientName"));
     //clearOnElement(By.name("Vgiftcard_43.RecipientName"));
     sendKey(By.name("giftcard_43.RecipientName"),"satyen");
     //for RecipientEmail
     clickOnElement(By.name("giftcard_43.RecipientEmail"));
     sendKey(By.name("giftcard_43.RecipientEmail"),"pqrs"+GetCurrentTimeStamp()+"@yahoo.com");
     //for message
     clickOnElement(By.name("giftcard_43.Message"));
     sendKey(By.name("giftcard_43.Message"),"hi, Dear");
     //click on Email a friend button
     clickOnElement(By.xpath("//div[@class='email-a-friend']/input"));

     // friend email
     clickOnElement(By.className("friend-email"));
     sendKey(By.className("friend-email"),"pqrs"+GetCurrentTimeStamp()+"@yahoo.com");
     //massage to friend
     clickOnElement(By.xpath("//div[@class='inputs']/textarea"));
     sendKey(By.xpath("//div[@class='inputs']/textarea"),"Hi,Dear Friend");
     //click on send email button
     clickOnElement(By.name("send-email"));

     //assert" Your message has been sent."
     String expectedResult="Your message has been sent.";
     String actualResult = driver.findElement(By.xpath("//div[@class='result']")).getText();
     Assert.assertEquals(expectedResult,actualResult);

     driver.close();




 }}

