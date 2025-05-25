import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v122.network.Network;
import org.openqa.selenium.devtools.v122.network.model.Request;
import org.openqa.selenium.devtools.v122.network.model.Response;

public class networkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriver driverWeb = new ChromeDriver(options);
		driverWeb.manage().window().maximize();

        // Cast to ChromiumDriver to access CDP
        ChromiumDriver driver = (ChromiumDriver) driverWeb;
		DevTools devTools = ((HasDevTools)driver).getDevTools();
		
		devTools.createSession();
		
		//first enable the network
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		
		devTools.addListener(Network.requestWillBeSent(), request->{
			Request req = request.getRequest();
			System.out.println("request url:"+req.getUrl());
			
		});
		
		devTools.addListener(Network.responseReceived(), response -> {
			Response res = response.getResponse();
			System.out.println("response Status: "+response.getResponse().getStatus());
			if(res.getStatus().toString().startsWith("4")) {
				System.out.println(res.getUrl()+" is failing with status code "+res.getStatus());
			}
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
		
	}

}
