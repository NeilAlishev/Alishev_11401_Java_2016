import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Nail Alishev
 *         11-401
 */
public class Server {
    final int PORT = 3456;
    ArrayList<Connection> connections;
    boolean newConnection = true;

    public Server() throws IOException {
        connections = new ArrayList<Connection>();
        go();
    }

    public void go() throws IOException {
        ServerSocket s1 = new ServerSocket(PORT);
        while (true) {
            Socket client = s1.accept();
            if (newConnection) {
                connections.add(new Connection(client, connections, connections.size()));
                newConnection = false;
            } else {
                Connection c = connections.get(connections.size() - 1);
                if (!c.isClosed()) {
                    c.addSecondPlayer(client);
                    newConnection = true;
                } else {
                    connections.remove(connections.size() - 1);
                    connections.add(new Connection(client, connections, connections.size()));
                    newConnection = false;
                }

            }
        }
    }

    /*
    public void resetConnection() {
        this.newConnection = true; //вызывает первый игрок, если закрывает окно не дождавшись соперника
    }*/

    public static void main(String[] args) throws IOException {
        ApplicationContextSingleton.getApplicationContext().getBean("sever");
    }
}
