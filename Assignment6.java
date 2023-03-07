/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;
 
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Assignment6 {
  public static void main(String[] args) {
      //Creating JText Area
    JFrame fr = new JFrame("Concurrent Output");
    JTextArea  ta1 = new JTextArea();
    ta1.setBounds(0, 0, 900, 700);
    ta1.setLineWrap(true);
    ta1.setWrapStyleWord(true);
      
    // Creating tasks
    Runnable printA = new PrintChar('a', 300, ta1);
    Runnable printB = new PrintChar('b', 250, ta1);
    Runnable print100 = new PrintNum(200, ta1);

    //Adding the created objects
        // to the frame
        fr.add(ta1);
        fr.setLayout(null);
        fr.setSize(920, 420);
        fr.setVisible(true);
        
    // Creating threads
    Thread thread1 = new Thread(printA);
    Thread thread2 = new Thread(printB);
    Thread thread3 = new Thread(print100);
    
    thread2.setPriority(Thread.MAX_PRIORITY);

    // Starting threads
    thread1.start();
    thread2.start();
    thread3.start();
  }
}

// The task for printing a specified character in specified times
class PrintChar implements Runnable {
  private char charToPrint; // The character to print
  private int times; // The times to repeat
  private JTextArea Text; //Creating text area for output 

  /** Construct a task with specified character and number of
   *  times to print the character
   */
  public PrintChar(char c, int t, JTextArea a) {
    charToPrint = c;
    times = t;
    Text = a;
  }

  @Override /** Override the run() method to tell the system
   *  what the task to perform
   */
  public void run() {
    for (int i = 0; i < times; i++) {
      Text.append(" " + Character.toString(charToPrint));
    }
  }
}

// The task class for printing number from 1 to n for a given n
class PrintNum implements Runnable {
  private int lastNum;
  private JTextArea Text; //Creating text area for output 
  
  /** Construct a task for printing 1, 2, ... i */
  public PrintNum(int n, JTextArea a) {
    lastNum = n;
    Text = a;
  }

  @Override /** Tell the thread how to run */
  public void run() {
    for (int i = 1; i <= lastNum; i++) {
      Text.append(" " + i);
      Thread.yield();
    }
  }
}
