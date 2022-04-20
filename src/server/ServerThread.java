package server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {

    private Socket socket;

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(socket.getInputStream());
            while (!socket.isClosed()) {
                while (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
