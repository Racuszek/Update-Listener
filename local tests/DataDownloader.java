import java.net.*;
import java.io.*;

class DataDownloader {
	void getStr(String urlToCheck) throws Exception {
		URL url=new URL(urlToCheck);
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
      	String line;
      	StringBuilder result=new StringBuilder();
      	while ((line = rd.readLine()) != null) {
        	 result.append(line);
      	}
      	rd.close();

      	String filePath="lastCheckSum.txt";
      	Writer bufferedWriter=null;

      	Writer fileWriter = new FileWriter(filePath);
		bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(Integer.toString(result.toString().hashCode()));
		System.out.println(result.toString().hashCode());
		bufferedWriter.close();
	}

}