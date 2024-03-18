package engtelecom.std.multicast;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Logger;

/**
 * Aplicação Servidor de hora Multicast.
 * 
 * Envia a hora atual em intervalos regulares para um grupo multicast.
 */
public class AppMulticastServer {

    // Para exibir mensagens de log
    private static Logger logger = Logger.getLogger(AppMulticastServer.class.getName());

    public static void main(String[] args) {
        String enderecoMulticast = "231.0.0.0";
        int porta = 8888;

        if (args.length == 2) {
            enderecoMulticast = args[0];
            porta = Integer.parseInt(args[1]);
        }

        try {
            MulticastTimeServer server = new MulticastTimeServer(enderecoMulticast, porta);
            // Inicia a thread do servidor de hora multicast
            new Thread(server).start();

        } catch (UnknownHostException | SocketException e) {
            logger.severe("Erro: " + e.getMessage());
        }
    }
}