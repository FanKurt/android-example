import java.io.BufferedOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
 
public class SocketClient {
    private String address = "172.20.10.13";// �s�u��ip
    private int port = 8765;// �s�u��port
 
    public SocketClient() {
 
        Socket client = new Socket();
        InetSocketAddress isa = new InetSocketAddress(this.address, this.port);
        try {
            client.connect(isa, 10000);
            BufferedOutputStream out = new BufferedOutputStream(client
                    .getOutputStream());
            // �e�X�r��
            out.write("Send From Client ".getBytes());
            out.flush();
            out.close();
            out = null;
            client.close();
            client = null;
 
        } catch (java.io.IOException e) {
            System.out.println("Socket�s�u�����D !");
            System.out.println("IOException :" + e.toString());
        }
    }
 
    public static void main(String args[]) {
        new SocketClient();
    }
}