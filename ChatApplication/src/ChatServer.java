
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peterh
 */
class ChatServer {

    void serve() {
        try {
            ServerSocket ss = new ServerSocket(0);
            System.out.println("I have port " + ss.getLocalPort());
            
                    
            while(true) {
                Socket s = ss.accept();
                
                ChatInterpreter ci = new ChatInterpreter(
                        s.getInputStream(), 
                        new PrintStream(s.getOutputStream()));
                
                Thread t = new Thread(ci);
                t.start();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
