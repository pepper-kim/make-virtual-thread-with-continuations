package demo.virtualthread;

public class Demo {
  public static void main(String[] args) {
    new VirtualThread(() -> {
      System.out.println("t1-1");
      WaitingOperator.sleep("Network I/O", 2000);
      System.out.println("t1-2");
      System.out.println("t1-3");
    }).start();

    new VirtualThread(() -> {
      System.out.println("t2-1");
      WaitingOperator.sleep("Database I/O", 5000);
      System.out.println("t2-2");
      System.out.println("t2-3");
    }).start();
  }
}
