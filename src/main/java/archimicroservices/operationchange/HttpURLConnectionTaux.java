package archimicroservices.operationchange;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionTaux {

    //private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpURLConnectionTaux http = new HttpURLConnectionTaux();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet("USD","EUR", "2018-06-24");

    }

    // HTTP GET request
    public double sendGet(String source, String dest, String date) throws Exception {

        String url = "http://localhost:8000/devise-change/taux/"+ source +"/"+ dest +"/" +date;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        //con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(Double.parseDouble(response.toString()));
        return Double.parseDouble(response.toString());

    }


}
