package lesson4.task1;

public class ABC {
    private static final Object monitor = new Object();
    private static volatile char currentChar = 'A';

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    synchronized (monitor) {
                        while (currentChar != 'A') {
                            monitor.wait();
                        }
                        System.out.print("A");
                        Thread.sleep(500);
                        currentChar = 'B';
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    synchronized (monitor) {
                        while (currentChar != 'B') {
                            monitor.wait();
                        }
                        System.out.print("B");
                        Thread.sleep(400);
                        currentChar = 'C';
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    synchronized (monitor) {
                        while (currentChar != 'C') {
                            monitor.wait();
                        }
                        System.out.print("C");
                        Thread.sleep(100);
                        currentChar = 'A';
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
