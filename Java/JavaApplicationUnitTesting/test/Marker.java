/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sami
 */
class Marker {
    
private String color;
private int inkAmount;
private boolean capOn;

    public Marker(String color) {
        inkAmount = 21;
        capOn = true;
        this.color = color;
    }

    public Marker() {
        inkAmount = 21;
        capOn = true;
        this.color = "black";
    }

    public String getColor() {
        return color;
    }

    public int getInkAmount() {
        return inkAmount;
    }

    public void capOff() {
        capOn = false;
    }

    public boolean draw() {
        if (!capOn){
            inkAmount--;
        }
        
        if(inkAmount == 0 || capOn){
            return false;
        }
        else {
            return true;
        }
            
    }
    
}
