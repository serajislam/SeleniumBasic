package seleniumBasic;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlingHttpCertificate {

	public static void main(String[] args) {
		
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions co = new ChromeOptions();
		
		
		co.merge(dc);
	}

}
