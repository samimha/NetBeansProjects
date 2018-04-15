package timetester;


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
public class Time implements Comparable<Time>{
    private int h;
    private int min;
    private Scanner reader;
    
    public Time(){
        reader = new Scanner(System.in);
    }
    
    public Time(int hour, int min){
        this.h = hour;
        this.min = min;
    }
    
    public void read(String text){
        System.out.println(text);
        System.out.print("h?    ");
        h = Integer.parseInt(reader.nextLine());
        System.out.print("min?  ");
        min = Integer.parseInt(reader.nextLine());
    }
    
    public boolean lessThan(Time time){
        if(this.h < time.h){
            return true;
        }
        if(this.min < time.min){
            return true;
        }
        return false;
    }
    
    public Time subtract(Time time){
        Time subtraction = new Time();
        subtraction.h = this.h - time.h;
        subtraction.min = this.min - time.min;
        if(time.min > this.min){
            subtraction.h --;
            subtraction.min += 60;
        }
        return subtraction;
    }
    
    @Override
    public String toString(){
        if (h < 10){
            if(min < 10){
                return "0" + this.h + ":0" + this.min;
            }
            return "0" + this.h + ":" + this.min;
        }
        if(min < 10){
                return this.h + ":0" + this.min;
            }
        return this.h + ":" + this.min;
    }

    @Override
    public int compareTo(Time time) {
        return Integer.compare(this.h, time.h) + Integer.compare(this.min, time.min);
    }
}
