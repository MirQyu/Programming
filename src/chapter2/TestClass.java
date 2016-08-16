package chapter2;

import java.util.Scanner;

public class TestClass {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		Counter counter1 = new Counter();
		Counter counter2 = new Counter();
		Thread thread1 = new Thread(counter1);
		Thread thread2 = new Thread(counter2);
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(counter1.count);
	}
}

class Counter implements Runnable{
	   public static int count = 0;

	   public Counter() {
	   }

	   public void countAdd() {
	      synchronized(this) {
	         for (int i = 0; i < 5; i ++) {
	            try {
	               System.out.println(Thread.currentThread().getName() + ":->>>>" + (count++));
	               Thread.sleep(100);
	            } catch (InterruptedException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	   }

	   //非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
	   public void printCount() {
	      for (int i = 0; i < 5; i ++) {
	         try {
	            System.out.println(Thread.currentThread().getName() + " count:" + count);
	            Thread.sleep(100);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	      }
	   }

	   public void run() {
	      String threadName = Thread.currentThread().getName();
	      System.out.println(threadName);
	      if (threadName.equals("Thread-0")) {
	         countAdd();
	      } else if (threadName.equals("Thread-1")) {
	         printCount();
	      }
	   }
	}
