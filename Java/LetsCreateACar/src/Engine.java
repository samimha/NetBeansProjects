/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sami
 */
public class Engine {
    private int mileage;
    private double fuelConsumption;
    
    public Engine(int mileage){
        if (mileage < 0){
            mileage = 0;
        }
        this.mileage = mileage;
        fuelConsumption = 0.05 + mileage/100000;
    }
    
    public Engine(){
        mileage = 0;
        fuelConsumption = 0.05 + mileage/100000;
    }
    public void run(){
        mileage++;
        fuelConsumption = 0.05 + (double)mileage/100000;
    }
    
    public double getFuelConsumption (){
        return fuelConsumption;
    }
    
    public int getMileage(){
        return mileage;
    }
}
