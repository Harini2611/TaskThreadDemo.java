/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Harini.Raj
 */
public class Assignment6_Q2 {
  private int sum = new Integer(0);

  public static void main(String[] args) {
    Assignment6_Q2 test = new Assignment6_Q2();
    System.out.println("What is sum ? " + test.sum);
  }

  public Assignment6_Q2() {
    ExecutorService executor = Executors.newFixedThreadPool(1000);

    for (int i = 0; i < 1000; i++) {
      executor.execute(new SumTask());
    }

    executor.shutdown();

    while(!executor.isTerminated()) {
    }
  }

  class SumTask implements Runnable {
    public void run() {
      sum++;
//      int value = sum.intValue() + 1;
//      sum = new Integer(value);
    }
  }
}
