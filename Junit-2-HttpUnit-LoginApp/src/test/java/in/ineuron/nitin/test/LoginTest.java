package in.ineuron.nitin.test;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class LoginTest {
	
	String url = "http://localhost:9999/HttpUnit-LoginApp/index.html";
	
	public static WebConversation conversation;
	
	@BeforeAll
	public void setUp() {
		conversation = new WebConversation();
	}
	
	
	@Test
	public void testLoginWithValidCredentials() throws IOException, SAXException {
		
		WebResponse response = conversation.getResponse(url);
		// get access to the form from the response
		WebForm webForm = response.getForms()[0];
		webForm.setParameter("uname", "sachin");
		webForm.setParameter("password", "tendulkar");
		
		WebResponse actualResponse = webForm.submit();
	}
	
	@Test
	public void testLoginWithInalidCredentials() {
		
	}
	
	
	@Test
	public void testLoginWithNoInputCredentials() {
		
	}

}
