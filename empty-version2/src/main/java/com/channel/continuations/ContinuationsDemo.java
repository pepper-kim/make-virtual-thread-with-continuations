package com.channel.continuations;

import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

public class ContinuationsDemo {
  public static void main(String[] args) {
    System.out.println("Hello, World!");
    ContinuationScope scope = new ContinuationScope("scope");
    Continuation continuation = new Continuation(scope, () -> {
      System.out.println("A");
    });

    continuation.run();
  }
}
