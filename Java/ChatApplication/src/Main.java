/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peterh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ChatInterpreter ci = new ChatInterpreter(System.in, System.out);
        ci.run();
        */
        
        ChatServer server = new ChatServer();
        server.serve();
    }
    
}
