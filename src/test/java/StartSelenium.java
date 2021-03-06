import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class StartSelenium {
    //before [open WWW.] ---> test [steps] + Assert ---> after [logout]
    //before [open browser]--> test [open www] ---> after [close www + browser]
    WebDriver wd;

    @BeforeMethod
    public void preCondition (){
        // open browser
        wd = new ChromeDriver();
    }
    @Test
    public void startContact(){
        //open www
        //without history
        //wd.get("https://contacts-app.tobbymarshall815.vercel.app/home");
        //with history
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/login");
        WebElement e1 =wd.findElement(By.tagName("div"));
        List<WebElement> list = wd.findElements(By.tagName("div"));

        System.out.println(list.size());
        WebElement elDiv2 = list.get(1);

        WebElement e2 = wd.findElement(By.id("root"));
        WebElement element3 = wd.findElement(By.className("login_login__3EHKB"));
        //WebElement e3 = wd.findElement(By.className("navbar-component_nav__1X_4m"));

        //cssSelector class(".")
        WebElement elementCss =wd.findElement(By.cssSelector(".login_login__3EHKB"));
        wd.findElement(By.cssSelector(".container"));

        //cssSelector id ("#")
        wd.findElement(By.cssSelector("#root"));

        //cssSelector atribut ("[placeholder='Email']")
        wd.findElement(By.cssSelector("[placeholder='Email']"));

    }

    @Test
    public void loginTest (){

        //step1 open www
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/login");

        //step2 click login button
        WebElement loginA = wd.findElement(By.className("active"));
        loginA.click();

        //step3 type email
        List<WebElement> listInputs = wd.findElements(By.tagName("input"));
        WebElement email = listInputs.get(0);
        email.click();
        email.clear();
        email.sendKeys("Yaniv@gmail.com");

        //step4 type password
        WebElement password = listInputs.get(1);
        password.click();
        password.click();
        password.sendKeys("Yy123456");

        //step5 click button login
        WebElement loginBtn = wd.findElement(By.tagName("button"));
        wd.findElement(By.cssSelector("button"));
        loginBtn.click();


    }

    @AfterMethod
    public void postCondition(){
        //close browser +www
        // close the window
        // wd.close();
        //close all
        wd.quit();
    }
}
