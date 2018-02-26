
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sami
 */
public class UserStore {
    
    private static List<String> usernames = new ArrayList<>();
    
    public static boolean contains(String un) {
        if(!usernames.contains(un)){
            usernames.add(un);
            return true;
        } else {
            return false;
        }
    }
    
}
