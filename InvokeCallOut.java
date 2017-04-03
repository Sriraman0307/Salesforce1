package CustomActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class InvokeCallOut {
	
	public static void main(String[] args) {

		  try {
			  
			URL url = new URL("https://app.hwlivetext.com/api/4.3/account/16788108775/message");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();	
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			//Account ID: 487c5776-e291-4152-8596-87b07b1b5c8a 
			//Activation Code: 690d7269-0a2e-45a7-88a1-da264da42f8e

			conn.setRequestProperty("AdminAccountId","487c5776-e291-4152-8596-87b07b1b5c8a");
			conn.setRequestProperty("AdminPassword","690d7269-0a2e-45a7-88a1-da264da42f8e");
			
			String input = "{\"To\":+13213187287,\"Body\":\"Check Sending SMS\"}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		 }

		}
}



	


