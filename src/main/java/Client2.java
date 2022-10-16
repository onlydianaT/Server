import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    private static final int PORT =8080;
    private static final String HOST = null;

    public static void main (String[] args) throws IOException {
        //Открываем клиентский socket, используем try,catch, т.к. socket требует закрытия
        try
                (Socket clientSocket=new Socket(HOST,PORT);
//            System.out.println("Server started");
                 //Создаем поток вывода, flush - очистка буфера
                 OutputStreamWriter out=new OutputStreamWriter(clientSocket.getOutputStream());
            //Создаем поток ввода
            BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ){
                out.write(" \n");
                out.flush();
                while (true){
                    String inp=in.readLine();
                    System.out.println(inp);
                    Scanner scanner=new Scanner(System.in);


                    if (inp.equals("Game is over")){
                        break;
                    }
                    //System.out.println(in.readLine());
//                inp=in.readLine();
//                System.out.println(inp);
                    // String read=in.readLine();
                    if (inp.equals("???")){
                        System.out.println("You have started the game. Input name of town");

//
                        inp=scanner.nextLine();
                        System.out.println(inp);
                        int length=inp.length()-1;
                        char letter= inp.charAt(length);
                        System.out.println(letter);
                        out.write(letter);
                        out.flush();
                        out.write(inp);
                        out.flush();
                        System.out.println(in.readLine());

//scanner.close();
                    }
                    //       }
                    else{

                        System.out.println(inp);
                        int length=inp.length()-1;
                        char letter= inp.charAt(length);
                        System.out.println(letter);
//
//                    inp=in.readLine();




                        out.write(letter);
                        out.flush();

                        System.out.println("Input name of town with first letter " +letter+ " or input end to stop this game");
                        inp= scanner.nextLine();
                        out.write(inp);
                        out.flush();
                        //scanner.close();
                    }
                }
                //Scanner scanner=new Scanner(System.in);
//                       out.println("Hello, server!!!");

//            System.out.println("You have started the game. Input name of town");
//            Scanner scanner=new Scanner(System.in);
//            inp=scanner.nextLine();
//            System.out.println(inp);
//            out.write(inp);
//            out.flush();
                //Принимаем то, что приходит с сервера

            }
            // System.out.println(in.readLine());

            //System.out.println(in.readLine());
//                clientSocket.close();
//                in.close();
//                out.close();


//                    }
//
                  catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
