
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Sami
 */
public class LetsCreateACar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner reader = new Scanner(System.in);
        Car myCar = new Car(0, 50, 20);
        boolean menuOn = true;
        loopy: while (menuOn){
            myCar.printStats();
            System.out.println("\nd: drive \nw: wash windscreen \nf: fill up washer tank \ng: fill gas tank \nq: quit \n");
            String input = reader.nextLine();
            switch(input){
                case "d":
                    System.out.println("how long? (kms)");
                    int kms = reader.nextInt();
                    myCar.drive(kms);
                    break;
                case "w":
                    myCar.washWindscreen();
                    break;
                case "f":
                    myCar.fillUpWasher();
                    break;
                case "g":
                    myCar.fillUpFuel();
                    break;
                case "q":
                    break loopy;
                default:
                    break;
            }
        }
        
    }
    
}
