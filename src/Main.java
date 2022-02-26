public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup mainGroup = new ThreadGroup("mainGroup");
        mainGroup.setMaxPriority(3);
        Thread thread1 = new MyThread(mainGroup, "Thread 1");
        Thread thread2 = new MyThread(mainGroup, "Thread 2");
        Thread thread3 = new MyThread(mainGroup, "Thread 3");
        Thread thread4 = new MyThread(mainGroup, "Thread 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(15000);
        mainGroup.interrupt();
    }
}