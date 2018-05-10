import java.net.*;
import java.io.*;
import java.util.Scanner;

class DataDownloader {
	void getStr(String urlToCheck) throws Exception {
		// Pobiera do zmiennej oldCheckSum zawartosc pliku z ostatnim hashem
		File oldSumFile=new File("LastCheckSum.txt");
        Scanner reader=new Scanner(oldSumFile);
        String oldCheckSum=reader.next();
        //---------------------------

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
      	String hash=Integer.toString(result.toString().hashCode());

      	if (hash.equals(oldCheckSum)) {
      		System.out.print("Nothing has changed.");
		}
		else {
      		System.out.println("Something has changed!");
      		//Now writing the new value to LastCheckSum.txt file
	      	String filePath="LastCheckSum.txt";
	      	Writer bufferedWriter=null;

	      	Writer fileWriter = new FileWriter(filePath);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(hash);
			System.out.println(result.toString().hashCode());
			bufferedWriter.close();
		}
	}

}