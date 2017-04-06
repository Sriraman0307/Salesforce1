import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;
import javax.tools.JavaFileObject;

public class InvokeCallOut {
	
public static void main(String[] args) {
		String ToNumber="13213187287";
		String BodySMS="Got+IT!";

  try {
	
	
	  
	URL url = new URL("https://app.hwlivetext.com/api/4.3/account/17206864418/message?to=%2B"+ToNumber+"&body="+BodySMS);

	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setDoOutput(true);
	conn.setRequestMethod("POST");
	conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");	
	conn.setRequestProperty("AdminAccountId","487c5776-e291-4152-8596-87b07b1b5c8a");
	conn.setRequestProperty("AdminPassword","690d7269-0a2e-45a7-88a1-da264da42f8e");
	
	System.out.println("Response Code:"+conn.getResponseCode()+conn.getInputStream()+" \n");
	conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		 }

		}
}



	


