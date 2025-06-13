package com.channel.virtualthread;

import java.util.Timer;
import java.util.TimerTask;

import jdk.internal.vm.Continuation;

public class WaitingOperator {

  public static void sleep(String name, long millis) {

    System.out.println("WaitingOperator.sleep " + name + " " + millis);
    VirtualThread vt = VirtualThreadScheduler.CURRENT_VIRTUAL_THREAD.get();

    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        VirtualThread.SCHEDULER.schedule(vt);
        timer.cancel();
      }
    }, millis);

    Continuation.yield(VirtualThread.SCOPE);
  }
}
