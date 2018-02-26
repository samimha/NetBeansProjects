/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peterh
 */
class ChatMessage {
    private final long timestamp;
    private final String content;
    private final String un;
    
    public ChatMessage(long timestamp, String content, String username) {
        this.timestamp = timestamp;
        this.content = content;
        un = username;
    }
    
    @Override
    public String toString() {
        return un + " says: " + content + " @ " + timestamp;
    }
    
}
