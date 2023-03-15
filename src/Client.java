
    import javax.imageio.IIOException;
    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.IOException;
    import java.net.Socket;
    import java.sql.SQLOutput;

    public class Client{

        private Socket socket;
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;

        public Client (Spcket socket) {
            try {
                this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.bufferedWriter = new BufferedWriter(new OutputStreamWirter(socket.getOutputStream()));
            } catch (IOException e) {
                System.out.println("Error creating client.");
                e.printStackTrace();
                closeEverything(socket,bufferedReader,bufferedWriter);
            }
        }

        public void sendMessageToServer(String messageToServer){
            try {
                bufferedWriter.write(messageToServer);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("Error sending message to the client");
                closeEverything(socket,bufferedReader,bufferedWriter);
            }
        }
        public void receiveMessageFromServer(VBox vBox){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (socket.isConnected()){
                        try {
                            String messageFromClient = bufferedReader.readLine();
                            Controller.addLabel(MessageFromServer,vBox);
                        }catch (IOException e){
                            e.printStackTrace();
                            System.out.println("Error receiving message from the client");
                            closeEverything(socket,bufferedReader,bufferedWriter);
                            break;
                        }
                    }
                }
            }).start();
        }
        public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter ){
      try {
          if (bufferedReader != null){
              bufferedReader.close();
          }
          if (bufferedWriter !=null){
              bufferedWriter.close();
          }
          if (socket!=null){
              socket.close();
          }
      }catch (IOException e){
          e.printStackTrace();
      }
        }

    }



