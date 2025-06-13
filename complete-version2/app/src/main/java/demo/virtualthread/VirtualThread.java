package demo.virtualthread;

import java.util.concurrent.atomic.AtomicInteger;

import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

public class VirtualThread {

  public static final VirtualThreadScheduler SCHEDULER = new VirtualThreadScheduler();

  private static final AtomicInteger COUNTER = new AtomicInteger(1);
  public static final ContinuationScope SCOPE = new ContinuationScope("virtual-thread");

  private final int id;
  private final Continuation continuation;

  public VirtualThread(Runnable runnable) {
    this.id = COUNTER.getAndIncrement();
    this.continuation = new Continuation(SCOPE, runnable);
  }

  public void start() {
    SCHEDULER.schedule(this);
  }

  public void runContinuation() {
    try {
      System.out.println("VirtualThread " + id + " is running on " + Thread.currentThread());
      VirtualThreadScheduler.CURRENT_VIRTUAL_THREAD.set(this);
      this.continuation.run();
    } finally {
      VirtualThreadScheduler.CURRENT_VIRTUAL_THREAD.remove();
    }
  }
}
