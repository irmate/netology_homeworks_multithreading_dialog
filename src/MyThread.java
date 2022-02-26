class MyThread extends Thread {

    public MyThread(ThreadGroup group, String name){
        super(group, name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2000);
                System.out.printf("I'm %s. Hello everybody!\n", getName());
            }
        } catch (InterruptedException ignored) {
        } finally {
            System.out.printf("%s cancelled\n", getName());
        }
    }
}