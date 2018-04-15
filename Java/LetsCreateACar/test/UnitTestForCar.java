/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sami
 */
public class UnitTestForCar {
    
    @Test public void carConstructorTest1(){
        Car car = new Car();
        assertTrue(car.mileage() == 0);
        assertTrue(car.fuel() == 50);
        assertTrue(car.washer() == 10);
    }
    
    @Test public void carCconstructorTest2(){
        Car car = new Car(70, 50, 15);
        assertTrue(car.mileage() == 70);
        assertTrue(car.fuel() == 50);
        assertTrue(car.washer() == 15);
    }
    
    @Test public void carCconstructorTest3(){
        Car car = new Car(-1, 0, -15);
        assertTrue(car.mileage() == 0);
        assertTrue(car.fuel() == 0);
        assertTrue(car.washer() == 0);
    }
    
    @Test public void driveTest(){
        Car car = new Car(10, 50, 10);
        car.drive(10);
        assertEquals(car.mileage(), 20);
    }
    
    @Test public void washerTest1(){
        Car car = new Car();
        car.washWindscreen();
        assertEquals(car.washer(), 9, 0);
        car.fillUpWasher();
        assertEquals(car.washer(), 10, 0);
    }
    
    @Test public void washerTest2(){
        Car car = new Car(0, 50, 1);
        assertEquals(car.washer(), 1, 0);
        car.washWindscreen();
        assertEquals(car.washer(), 0, 0);
        car.washWindscreen();
        car.washWindscreen();
        assertEquals(car.washer(), 0, 0);
    }
    
    @Test public void fuelTest1(){
        Car car = new Car();
        assertEquals(car.fuel(), 50, 0);
        car.drive(20);
        assertTrue(car.fuel() < 50);
        car.fillUpFuel();
        assertEquals(car.fuel(), 50, 0);
    }
    
    @Test public void fuelTest2(){
        Car car = new Car();
        car.drive(1000000000);
        assertTrue(car.fuel() >= 0);
    }
    
    @Test public void engineConstructorTest1(){
        Engine engine = new Engine();
        assertEquals(engine.getMileage(), 0);
    }
    
    @Test public void engineConstructorTest2(){
        Engine engine = new Engine(5);
        assertEquals(engine.getMileage(), 5);
    }
    
    @Test public void fuelConsumptionTest(){
        Engine engine = new Engine();
        double consumptionAtStart = engine.getFuelConsumption();
        engine.run();
        double consumptionLater = engine.getFuelConsumption();
        assertTrue(consumptionAtStart < consumptionLater);
    }
    
    @Test public void mileageTest(){
        Engine engine = new Engine();
        engine.run();
        assertEquals(engine.getMileage(), 1);
    }
    
    @Test public void tankConstructorTest1(){
        Tank tank = new Tank();
        assertEquals(tank.getAmount(), 50, 0);
    }
    
    @Test public void tankConstructorTest2(){
        Tank tank = new Tank(30);
        assertEquals(tank.getAmount(), 30, 0);
    }
    
    @Test public void consumeTest(){
        Tank tank = new Tank(30);
        tank.consume(40);
    }
    
    @Test public void fillUpTest(){
        Tank tank = new Tank(30);
        tank.consume(1);
        assertEquals(tank.getAmount(), 29, 0);
        tank.fillUp();
        assertEquals(tank.getAmount(), 30, 0);
    }
}
