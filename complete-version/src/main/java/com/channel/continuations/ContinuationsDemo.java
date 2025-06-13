package com.channel.continuations;

import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

public class ContinuationsDemo {
  public static void main(String[] args) {
    System.out.println("Hello, World!");
    ContinuationScope scope = new ContinuationScope("scope");
    Continuation continuation = new Continuation(scope, () -> {
      System.out.println("A");
      System.out.println("B");
      Continuation.yield(scope);
      System.out.println("C");
    });

    continuation.run();
    System.out.println("Im in main method");
    continuation.run();
  }
}
