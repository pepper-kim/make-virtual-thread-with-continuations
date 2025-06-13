package com.channel.virtualthread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class VirtualThreadScheduler {

  public static final ThreadLocal<VirtualThread> CURRENT_VIRTUAL_THREAD = new ThreadLocal<>();

  private final BlockingQueue<VirtualThread> queue = new LinkedBlockingQueue<>();
  private final Executor executor = Executors.newSingleThreadExecutor();

  public VirtualThreadScheduler() {
    executor.execute(() -> {
      while (true) {
        try {
          VirtualThread vt = queue.take();
          vt.runContinuation();
        } catch (InterruptedException e) {
          e.printStackTrace();
          break;
        }
      }
    });
  }

  public void schedule(VirtualThread vt) {
    queue.add(vt);
  }
}
