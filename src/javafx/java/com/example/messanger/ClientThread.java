package com.example.messanger;

import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Thread {

    private final Socket socket;

    private TextArea messagesField;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(socket.getInputStream());
            while (!socket.isClosed()) {
                while (scanner.hasNextLine()) {
                    messagesField.setText(messagesField.getText() + scanner.nextLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        try {
            writeStringToOutputStream(socket.getOutputStream(), msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeStringToOutputStream(OutputStream outputStream, String msg) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write(msg);
        outputStreamWriter.flush();
    }


    public void setTextArea(TextArea messagesField) {
        this.messagesField = messagesField;
    }
}
