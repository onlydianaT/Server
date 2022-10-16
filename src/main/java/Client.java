import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private static final int PORT = 8080;
    private static final String HOST = null;

    public static void main(String[] args) throws IOException {
        //Открываем клиентский socket, используем try,catch, т.к. socket требует закрытия
        try (Socket clientSocket = new Socket(HOST, PORT);
             //Создаем поток вывода, flush - очистка буфера
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             //Создаем поток ввода
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String smth = in.readLine();
            System.out.println(smth);
            if (!smth.equals("???")) {
                System.out.println("Input name of town with last letter of sent town");
                Scanner scanner = new Scanner(System.in);
                String newTown = scanner.nextLine();
                out.println(newTown);
                System.out.println(in.readLine());
                in.close();
                out.close();
                clientSocket.close();
            } else {
                System.out.println("You need to input name of any town");
                Scanner scanner = new Scanner(System.in);
                String inp = scanner.nextLine();
                out.println(inp);
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}




