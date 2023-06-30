import java.net.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("127.0.0.1", 8000);

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        clientSocket.getOutputStream()));
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        writer.write("Get me some information");
        writer.newLine();
        writer.flush();

        String response = reader.readLine();
        System.out.println(response);

        writer.close();
        reader.close();
        clientSocket.close();
    }
}