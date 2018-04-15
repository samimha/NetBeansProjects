
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peterh
 */
public class MessageStore {
    private final List<ChatMessage> messages;
    private final Set<MessageStoreObserver> observers;
    
    private MessageStore() {
        this.messages = new ArrayList<>();
        this.observers = new HashSet<>();
    }
    
    public void add(ChatMessage cm) {
        this.messages.add(cm);
        for(MessageStoreObserver mso: observers) {
            mso.newMessage(cm);
        }
    }
    
    public String toString() {
        String result ="";
        for(ChatMessage cm: this.messages) {
            result += cm.toString() + "\n";
        }
        return result;
    }
    
    public static MessageStore getInstance() {
        return MessageStoreHolder.INSTANCE;
    }

    void register(MessageStoreObserver aThis) {
        observers.add(aThis);
    }

    void deregister(MessageStoreObserver aThis) {
        observers.remove(aThis);
    }
    
    private static class MessageStoreHolder {
        private static final MessageStore INSTANCE = new MessageStore();
    }
}
