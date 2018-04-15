
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author peterh
 */
class ChatInterpreter implements Runnable, MessageStoreObserver {

    private final InputStream in;
    private final PrintStream out;

    ChatInterpreter(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        out.println("Welcome");
        out.println("Enter username:");
        Scanner sc = new Scanner(in);
        String un;
        do {
            un = sc.nextLine();
            if (UserStore.contains(un)) {
                break;
            } else{
                out.println("Username already taken");
                System.out.println("Try again: ");
            }
        } while (true);

        String line;
        MessageStore.getInstance().register(this);

        do {
            //out.print("Yessir: ");
            line = sc.nextLine();

            if (!line.startsWith(":")) {
                //out.println("Message: " + line);
                MessageStore.getInstance().add(new ChatMessage(
                        System.currentTimeMillis(),
                        line, un));
            } else if (line.equals(":print")) {
                out.println(MessageStore.getInstance().toString());
            }
        } while (!line.equals(":quit"));

        MessageStore.getInstance().deregister(this);

        out.println("Goodbye.");

        out.close();
    }

    @Override
    public void newMessage(ChatMessage cm) {
        out.println(cm);
    }

}
