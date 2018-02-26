/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sami
 */
public class Tank {
    private double capasity;
    private double amount;
    
    public Tank(double amount){
        if(amount < 0){
            amount = 0;
        }
        this.capasity = amount;
        this.amount = amount;
    }
    
    public Tank(){
        capasity = 50;
        amount = capasity;
    }
    
    public void fillUp(){
        amount = capasity;
    }
    
    public void consume(double amount) {
        if (amount > this.amount){
            amount = this.amount;
        }
        this.amount -= amount;
    }
    
    public double getAmount(){
        return amount;
    }
}
