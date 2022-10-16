import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final int PORT = 8080;


    public static void main(String[] args) throws IOException {

        //Открываем серверный socket, используем try,catch, т.к. socket требует закрытия
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");
            int count = 0;
            //Запускаем вечный цикл
            List<String> towns = new ArrayList<>();
            while (true) {
                //Ожидаем подключения
                //После открытия серверный сокет откроет клиентский сокет
                try (Socket clientSocket = serverSocket.accept();
                     //Создаем поток вывода
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                     //Создаем поток ввода
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    if (count == 0 && towns.isEmpty()) {
                        out.println("???\n");
                        String town = in.readLine().toLowerCase();
                        towns.add(town);


                    } else if (count != 0 && towns.size() >= 1) {
                        int size = towns.size() - 1;
                        String previousTown = towns.get(size);
                        out.println(previousTown);
                        String newTown = in.readLine().toLowerCase();

                        if (newTown.equals("end")) {
                            out.println("Game is over");
                            break;
                        } else {
                            int length = previousTown.length() - 1;
                            char letter = previousTown.charAt(length);
                            String lastLetter = String.valueOf(letter);
                            char firstLetter = newTown.charAt(0);
                            String first = String.valueOf(firstLetter);

                            if (lastLetter.equals(first)) {
                                towns.add(newTown);
                                out.println("ok");

                            } else {
                                out.println("not ok");
                            }
                        }
                    }

                }
                count++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}













