package com.example.messanger;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField message;

    @FXML
    private TextArea messagesField;

    private ClientThread clientThread;

    @FXML
    protected void sendChat() {
        String userMessage = message.getText();
        message.setText("");
        sendMessage(userMessage);
    }

    public void sendMessage(String msg) {
        if(clientThread == null) {
            clientThread = HelloApplication.clientThread;
            clientThread.setTextArea(messagesField);
        }
        clientThread.sendMessage(msg);
    }
}