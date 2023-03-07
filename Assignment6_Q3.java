/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harini.Raj
 */
public class Assignment6_Q3 {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        Runnable add = new AddNumber(numbers);
        Runnable trav = new TraverseSet(numbers);
        Thread thread1 = new Thread(trav);
        Thread thread2 = new Thread(add);
        thread2.start();
        thread1.start();
    }
}
// Creating a HashSet object called numbers
 class AddNumber implements Runnable{
    HashSet<Integer> numbers;
    public AddNumber(HashSet<Integer> N){
        numbers = N;
    }
    public void run(){
        for (int i = 0; ;i++){
            numbers.add(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AddNumber.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

 class TraverseSet implements Runnable {
     HashSet<Integer> numbers;
    public TraverseSet(HashSet<Integer> N){
        numbers = N;
    }
    public void run(){
        for (int i = 0; ;i++){
            HashSet<Integer> copy;
            synchronized (numbers){
                copy = numbers;
            }
                Iterator <Integer> ITR = copy.iterator();
        while (ITR.hasNext()){
        System.out.println(ITR.next());
        }
            try {
             Thread.sleep(1000);
         } catch (InterruptedException ex) {
             Logger.getLogger(TraverseSet.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    }
 }

