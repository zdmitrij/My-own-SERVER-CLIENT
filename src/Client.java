import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {



        try (
                Socket socket = new Socket("www.yandex.ru", 80);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader((new InputStreamReader(socket.getInputStream())));
                
        ) {
            System.out.println("Connected to server");
            String request = "GET";
            System.out.println("Request - " + request);
            writer.write(request);
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println("Response " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
