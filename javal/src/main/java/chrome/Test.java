package chrome;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Test{

    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "/home/sakura/Downloads/chromedriver");
        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--disable-extensions");
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://conf.sys.pt.miui.com");
//        WebElement newbtn = driver.findElement(By.className("ant-btn"));
//        newbtn.click();

        //wait for log in
        Thread.sleep(20000);  // Let the user actually see something!

        //开始录入
        System.out.println("开始录入");

        driver.get("http://conf.sys.pt.miui.com/kinship/index.html#/data");
        Thread.sleep(3000);  // Let the user actually see something!

        Scanner scanner=new Scanner(new File("/home/sakura/Downloads/alltable.csv"));
        int filtered=0;
        while (scanner.hasNextLine()){
            String line=scanner.nextLine();
            String[] filed=line.split(",");

            if(filed.length!=5){
                System.err.println(line);
                filtered++;
            }

            String id=filed[0];
            String name=filed[1];
            String path=filed[2];
            String email=filed[3];
            String cluster=filed[4];
            String url="http://dp.pt.xiaomi.com/view?id="+id;

            WebElement newbtn = driver.findElement(By.className("ant-btn"));
            newbtn.click();

            WebElement inputid = driver.findElement(By.id("normal_login_tableId"));
            WebElement inputname = driver.findElement(By.id("normal_login_tablename"));
            WebElement inputcluster = driver.findElement(By.id("normal_login_cluster"));
            WebElement inputurl = driver.findElement(By.id("normal_login_url"));
            WebElement inputpath = driver.findElement(By.id("normal_login_path"));


            inputid.clear();
            inputname.clear();
            inputcluster.clear();
            inputurl.clear();
            inputpath.clear();

            inputid.sendKeys(id);
            inputname.sendKeys(name);
            inputcluster.sendKeys(cluster);
            inputurl.sendKeys(url);
            inputpath.sendKeys(path);

            inputpath.submit();

            Thread.sleep(1000);  // Let the user actually see something!

        }
        driver.quit();
    }

    public static void read(){

    }
}
