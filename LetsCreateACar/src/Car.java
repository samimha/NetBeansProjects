/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sami
 */
public class Car {

    private Engine engine;
    private Tank fuelTank;
    private Tank washerTank;
    
    public Car(int odo, int fuel, int washer) {
        fuelTank = new Tank(fuel);
        washerTank = new Tank(washer);
        engine = new Engine(odo);
    }
    
    public Car(){
        fuelTank = new Tank(50);
        washerTank = new Tank(10);
        engine = new Engine(0);
    }
    
    public void washWindscreen(){
        if(washerTank.getAmount() > 0)
            washerTank.consume(1);
    }
    
    public void drive (int kms){
        for(int i = kms; i > 0; i--){
            if(fuelTank.getAmount() - engine.getFuelConsumption() >= 0){
                engine.run();
                fuelTank.consume(engine.getFuelConsumption());
            } else {
                break;
            }
        }
    }
    
    public void fillUpWasher(){
        washerTank.fillUp();
    }
    
    public void fillUpFuel(){
        fuelTank.fillUp();
    }
    
    public void printStats(){
        System.out.println("odo: " + mileage() + "\nfuel:" + String.format("%.2f", fuel()));
        if (washer() == 0){
            System.out.println("*washer tank empty*");
        }
    }
    
    public int mileage(){
        return engine.getMileage();
    }
    
    public double fuel(){
        return fuelTank.getAmount();
    }
    
    public double washer(){
        return washerTank.getAmount();
    }
    
    public double consumption(){
        return engine.getFuelConsumption();
    }
}
