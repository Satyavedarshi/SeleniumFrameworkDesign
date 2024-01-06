package chromedevtools;

import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver dr1 = new ChromeDriver();
		
		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
		
		((HasAuthentication)dr1).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
		
		dr1.get("https://httpbin.org/basic-auth/foo/bar");
		
		

	}

}
