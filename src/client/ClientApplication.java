package client;

import com.example.messanger.HelloApplication;
import shared.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientApplication {

    public static void writeObjectToOutputStream(OutputStream outputStream) throws IOException {
        ObjectOutputStream diarrhea = new ObjectOutputStream(outputStream);

        Message message = new Message();
        message.setCommand("SEND_DATA");
        message.setData("data data need more data");

        diarrhea.writeObject(message);
        diarrhea.flush();
        diarrhea.close();
    }

    public static void writeStringToOutputStream(OutputStream outputStream) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write("NEW_USER\n\n");
        outputStreamWriter.write("data");
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

    public static void main(String[] args) throws IOException {
        HelloApplication.main(args);

            Socket socket = new Socket("localhost", 8000);
            writeObjectToOutputStream(socket.getOutputStream());
           // writeStringToOutputStream(socket.getOutputStream());

    }
}
